package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
 
    // view my profile
    @RequestMapping(value={"/profile"}, method = RequestMethod.GET)
    public ModelAndView viewMyBlog() {
    	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();     	
        User us = userService.getUserByUsername(username); 
        UserDTO userDto = userService.convertToDTO(us);
        ModelAndView mv= new ModelAndView();
             
        mv.addObject("userDto", userDto);
        mv.setViewName("profile");
        return mv;
    }
    
    // Edit profile
    @RequestMapping(value ="/editProfile", method = RequestMethod.GET)
    public String createBlogg(){ 
        return "editProfile";
    }
    @RequestMapping(value={"/editProfile"}, method = RequestMethod.POST)
    public String createBlog(Model model, @RequestParam String fullname, @RequestParam String picture){
    	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();  
        User us = userService.getAuthorized(username);  
    	us.setFullname(fullname);
    	us.setProfilePictureUrl(picture);
    	userService.editUserById(us.getUserID(), us);
    	return "redirect:/profile/";
    }
}
