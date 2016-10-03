package swd.presentation.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import swd.business.service.UserService;
import swd.persistence.entity.model.User;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
 
    @Autowired
    protected AuthenticationManager authenticationManager;

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
        if (us == null){
            System.out.println("user is not valid");
            return "login?logout";
        }
        session.setAttribute("userId", us.getUserID());
        session.setAttribute("fullname", us.getFullname());
        session.setAttribute("role", us.getRole());
        return "home";
    }
    @RequestMapping(value ="/signup", method = RequestMethod.GET)
    public String signup(){
        System.out.println("sign up page");
        return "signup";
    }

    @RequestMapping(value ="/signup", method = RequestMethod.POST)
    public String signupPos(Model model, @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullname,
            HttpServletRequest request
            ){
        boolean result =  userService.signUp(username, password, fullname);
        if (!result){
            return "signup";
        } 
        
        authenticateUserAndSetSession(username, password, request);

        return "redirect:/home/";
    }

    private void authenticateUserAndSetSession(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
  
    
    
}
