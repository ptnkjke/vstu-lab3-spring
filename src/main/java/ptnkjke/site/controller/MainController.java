package ptnkjke.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptnkjke.site.entity.DescriptionEntity;
import ptnkjke.site.entity.PageEntity;
import ptnkjke.site.service.SiteService;

import java.util.List;

/**
 * Created by Lopatin on 08.06.2014.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(ModelMap modelMap) {
        return "main/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/production")
    public String production(ModelMap modelMap) {
        List<DescriptionEntity> descriptionEntityList = siteService.getProductList();
        modelMap.put("entityList", descriptionEntityList);
        return "main/production";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public String services(ModelMap modelMap) {
        List<DescriptionEntity> descriptionEntityList = siteService.getServiceList();
        modelMap.put("entityList", descriptionEntityList);
        return "main/production";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/about")
    public String about(ModelMap modelMap) {
        PageEntity pageEntity = siteService.getPageAbout();
        modelMap.put("page", pageEntity);
        return "main/about";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contacts")
    public String contacts(ModelMap modelMap) {
        PageEntity pageEntity = siteService.getPageContact();
        modelMap.put("page", pageEntity);
        return "main/contacts";
    }

    /**
     * Простенький редирект
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String admin() {
        return "redirect:admin/";
    }
}
