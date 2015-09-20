package org.sails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by Nodirbek on 15.04.2015.
 */

@Controller
public class MainController {

    @RequestMapping({"/index.html", "/","index.htm","welcome.htm"})
    public ModelAndView welcome(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("public/welcome");
        modelAndView.addObject("catalinaHome", System.getProperty("catalina.home"));
        modelAndView.addObject("catalinaBase", System.getProperty("catalina.base"));
        modelAndView.addObject("contextRelPath", httpServletRequest.getServletContext().getRealPath(""));

        return modelAndView;
    }
    @RequestMapping(value = "/barcode.htm")
    public ModelAndView barcodeScanner(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("barcode");
        return modelAndView;
    }
}
