package swd.presentation.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @RequestMapping(value={"/", "/home"}, method = {RequestMethod.GET, RequestMethod.POST})
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
        return "signup";
    }

    @RequestMapping(value ="/signup", method = RequestMethod.POST)
    public String signupPos(Model model, @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullname,
            @RequestParam String confirmPassword,
            HttpServletRequest request
            ){
        StringBuilder urlErrParam = new StringBuilder("?");
        Pattern p = Pattern.compile(UserService.regExPatternUsername);
        Matcher m = p.matcher(username);   
        if (!m.find() || username.compareTo(m.group(0)) != 0){
            urlErrParam.append("usn&");
        }
        p = Pattern.compile(UserService.regExPatternPassword);
        m = p.matcher(password);   
        if (!m.find() || password.compareTo(m.group(0)) != 0){
            urlErrParam.append("pas&");
        }
        if ( password.compareTo(confirmPassword) != 0){
            urlErrParam.append("cfp&");
        }
        p = Pattern.compile(UserService.regExPatternFullname);
        m = p.matcher(fullname);   
        if (!m.find() || fullname.compareTo(m.group(0)) != 0){
            urlErrParam.append("fln&");
        }
        urlErrParam.deleteCharAt(urlErrParam.length()-1);
         
        if (urlErrParam.length() == 0){
            boolean result =  userService.signUp(username, password, fullname);
            if (!result){
                return "signup?ext";
            } else { 
                authenticateUserAndSetSession(username, password, request); 
                return "redirect:/home/";
            }
        } else {
            return "redirect:/signup"+urlErrParam;
        }
      
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
