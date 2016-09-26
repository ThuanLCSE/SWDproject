package swd.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swd.business.service.UserService;
import swd.persistence.entity.model.User;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("welcome")
    public String greeting(Model model){
        System.out.println("index Controller aaahandling!");
        return "index";
    }
    @RequestMapping("userAll")
    public String setupForm(Model model) 
    {
        List<User> users = userService.getAllUser();
        System.out.println("USER Controller aaahandling!");
        model.addAttribute("user", users);
        return "index";
    }
 
    
}
