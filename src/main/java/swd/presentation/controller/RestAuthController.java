package swd.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import swd.presentation.DTO.UserDTO;

@RestController
@RequestMapping("/api/auth")
public class RestAuthController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ErrorMessageDTO authenticated(HttpSession session, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ErrorMessageDTO errDto = new ErrorMessageDTO();
        boolean auth = userService.getAuthenticated(username, password);
      
        if (!auth){
            errDto.setstate(401);
            errDto.setMessage("username or password errs");
          return errDto;
        } else {
            User userEnt = userService.getAuthorized(username);
            session.setAttribute("userId", userEnt.getUserID());
            session.setAttribute("fullname", userEnt.getFullname());
            session.setAttribute("role", userEnt.getRole());
            errDto.setstate(200);
            errDto.setMessage(session.getId());
            return errDto; 
        } 
    }
    @RequestMapping(value="/profile/{userId}",method = RequestMethod.POST)
    public UserDTO viewProfile(@PathVariable int userId) {
      
        User userEnt = userService.getUserById(userId); 
        UserDTO userDto = userService.convertToDTO(userEnt);
        System.out.println(userDto.toString());
        return userDto;
     
    }
    @RequestMapping(value="/edit/{userId}",method = RequestMethod.POST)
    public boolean editProfile(@PathVariable int userId, @RequestBody UserDTO userDto) { 
        boolean result = userService.editUserById(userId, userService.convertToEnt(userDto));  
        return result;
     
    }
    @RequestMapping(value="/current",method = RequestMethod.GET)
    public UserDTO getAuthenticatedInfo(HttpSession session) { 
        UserDTO currentUser = new UserDTO();
        currentUser.setUserID(Integer.parseInt(session.getAttribute("userId")+"")); 
        currentUser.setFullname(session.getAttribute("fullname")+"");
        currentUser.setRole(session.getAttribute("role")+""); 
        return currentUser;
     
    }
   
    
}
