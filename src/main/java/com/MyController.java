package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String Hello(Model model)
    {
        //model.addAttribute("hell", "Something");
        return "hello";
    }
    @GetMapping("/home")
    public String Home(Model model)
    {
        //model.addAttribute("hell", "Something");
        return "home";
    }
    @GetMapping("/login")
    public String Login(Model model)
    {
        //model.addAttribute("hell", "Something");
        return "login";
    }

}
