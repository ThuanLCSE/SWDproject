package swd.presentation.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd.business.service.UserService;
import swd.persistence.entity.model.User;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @RequestMapping(value= "/login", method = RequestMethod.GET)
    public String loginget(ModelMap model, HttpSession session ) {
        
        return "login";

    }
    @RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
    public String homePage(HttpSession session,
            Model model) {
       
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();  
        User us = userService.getAuthorized(username);
        session.setAttribute("userId", us.getUserID());
        session.setAttribute("fullname", us.getFullname());
        session.setAttribute("role", us.getRole());
        return "home";
    }
  
    
    
}
