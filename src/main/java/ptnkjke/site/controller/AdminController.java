package ptnkjke.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ptnkjke.site.controller.model.DescriptionModel;
import ptnkjke.site.controller.model.HtmlPage;
import ptnkjke.site.controller.model.User;
import ptnkjke.site.entity.BaseEntity;
import ptnkjke.site.entity.DescriptionEntity;
import ptnkjke.site.entity.ImgFile;
import ptnkjke.site.entity.TypeDescription;
import ptnkjke.site.service.SecureService;
import ptnkjke.site.service.SiteService;

import javax.servlet.http.HttpSession;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SiteService siteService;
    @Autowired
    private SecureService secureService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String dashBoard(ModelMap modelMap, HttpSession session) {
        if (secureService.isAuth(session)) {
            modelMap.put("aboutHtml", siteService.getPageAbout());
            modelMap.put("contactsHtml", siteService.getPageContact());
            modelMap.put("services", siteService.getServiceList());
            modelMap.put("products", siteService.getProductList());
            return "admin/dashboard";
        }

        modelMap.put("User", new User());
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@ModelAttribute("User") User user, HttpSession session, ModelMap modelMap) {
        if (secureService.auth(user.getLogin(), user.getPassword(), session)) {
            return "redirect:/admin";
        }

        modelMap.put("error", "Неправильные данные для входа");
        return "main/error/error";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/about")
    public String changeAbout(@ModelAttribute("HtmlPage") HtmlPage htmlPage) {
        siteService.savePageAbout(htmlPage.getContant());
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/production/add")
    public String addProduction(@ModelAttribute("DescriptionModel") DescriptionModel descriptionModel) {
        ImgFile file = siteService.createImgFile(descriptionModel.getFile());
        DescriptionEntity de = new DescriptionEntity();
        de.setTypeDescription(TypeDescription.PRODUCT);
        de.setName(descriptionModel.getName());
        de.setImgFile(file);
        file.setDescription(de);
        siteService.saveorUpdate(de);
        siteService.saveorUpdate(file);
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/service/add")
    public String addService(@ModelAttribute("DescriptionModel") DescriptionModel descriptionModel) {
        ImgFile file = siteService.createImgFile(descriptionModel.getFile());
        DescriptionEntity de = new DescriptionEntity();
        de.setTypeDescription(TypeDescription.SERVICE);
        de.setName(descriptionModel.getName());
        de.setImgFile(file);
        file.setDescription(de);
        siteService.saveorUpdate(de);
        siteService.saveorUpdate(file);
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/descrDel/{id}")
    public String deleteDescr(@PathVariable(value = "id") Integer id) {
        siteService.delete(id, DescriptionEntity.class);
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contacts")
    public String changeContacts(@ModelAttribute("HtmlPage") HtmlPage htmlPage) {
        siteService.savePageContact(htmlPage.getContant());
        return "redirect:/admin";
    }
}
