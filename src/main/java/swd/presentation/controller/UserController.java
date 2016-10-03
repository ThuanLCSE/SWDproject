package swd.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd.business.service.UserService;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.UserDTO;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
   
    @RequestMapping("userAll")
    public String setupForm(Model model) 
    {
        List<User> users = userService.getAllUser();
        model.addAttribute("user", users);
        return "index";
    }
 
    
}
