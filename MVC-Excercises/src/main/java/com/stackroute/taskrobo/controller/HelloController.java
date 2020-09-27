package com.stackroute.taskrobo.controller;

import com.stackroute.taskrobo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hey")
    public String sayHello(Model model) {
        model.addAttribute("msg", "Hello Earth");
        return "index";
    }

    @RequestMapping("login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping("showMessage")
    public ModelAndView showMessage(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("message");
        modelAndView.addObject("userObject", user);
        return modelAndView;
    }
}
