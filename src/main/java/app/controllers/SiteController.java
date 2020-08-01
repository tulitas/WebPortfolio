package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class SiteController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @RequestMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("registration");

    }

    @RequestMapping("/reg")
    public ModelAndView reg() {
        return new ModelAndView("reg");

    }

}