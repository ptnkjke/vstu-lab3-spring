package ptnkjke.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Controller
@RequestMapping("/")
public class ErrorController {

    @RequestMapping(value = "/error404")
    public String error404() {
        return "main/error/error404";
    }
}
