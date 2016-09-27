package swd.presentation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swd.business.service.UserService;
import swd.persistence.entity.model.User;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @RequestMapping(value= "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User guest, HttpSession session){
        ModelAndView mv = new ModelAndView();
        boolean authen = userService.getAuthenticated(guest.getUsername(), guest.getPassword());
        if (authen){
           
            User authorize = userService.getAuthorized(guest.getUsername());
            session.setAttribute("userId", authorize.getUserID());
            session.setAttribute("role", authorize.getRole());
            session.setAttribute("fullname", authorize.getFullname());
            
           
            String redirectUrl = "/home";
            mv.setViewName("redirect:" + redirectUrl);
            return mv;
           
        } else {
            mv.setViewName("login");
        }
        return mv;
    }
    
    
}
