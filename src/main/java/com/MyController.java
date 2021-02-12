package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableWebSecurity
@Controller
public class MyController {
    @Autowired
    MyDB myDB;
    @GetMapping("/")
    public String Hello()
    {
        return "hello";
    }
    @GetMapping("/home")
    public String Home()
    {
        return "home";
    }
    @GetMapping("/login")
    public String Login()
    {
        return "login";
    }
    @GetMapping("/animals")
    public String Animals(Model model)
    {
        model.addAttribute("animalsList", myDB.getAllAnimals());
        return "animals";
    }
    @GetMapping("/new")
    public String newAnimal(Model model)
    {
        model.addAttribute("animal", new Animal());
        return "new";
    }
    @GetMapping("/creating")
    public String Creating(@RequestParam(name ="name", required = false) String name,
                           @RequestParam (name="cost", required = false) int cost)
    {
        myDB.newAnimal(name, cost);
        return "redirect:animals";
    }
    @GetMapping("/dell")
    public String dellAnimal(Model model)
    {
        model.addAttribute("animal", new Animal());
        return "dell";
    }
    @GetMapping("/deleting")
    public String Deleting(@RequestParam(name="name", required = false) String name)
    {
        myDB.deleteAnimal(name);
        return "redirect:animals";
    }
}
