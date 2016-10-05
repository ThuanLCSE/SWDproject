package swd.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;

import swd.business.service.BlogService;
import swd.business.service.UserService;
import swd.persistence.entity.model.Publishedblog;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.ErrorMessageDTO;

@RestController
@RequestMapping("/api/auth")
public class RestAuthController {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.POST)
    public ErrorMessageDTO authenticated(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean auth = userService.getAuthenticated(username, password);
        ErrorMessageDTO err =  new ErrorMessageDTO();
        if (!auth){
            err.setType(401);
            err.setMessage("Wrong username and password");
        } else {
            User userEnt = userService.getAuthorized(username);
            err.setType(200);
            err.setMessage(userEnt.getUserID()+":"+userEnt.getRole()+":"+userEnt.getFullname());
        }
        System.out.println(err.toString());
        return err;
    }
   
    
}
