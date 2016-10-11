package swd.presentation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swd.business.service.BlogService;
import swd.business.service.LikeService;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.ErrorMessageDTO;

@RestController
@RequestMapping("/api/like")
public class RestLikeController {
    @Autowired
    private LikeService likeService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  ErrorMessageDTO create(@RequestBody BlogDTO blog, HttpSession session) {
            ErrorMessageDTO result = new ErrorMessageDTO();  
             int userId = Integer.parseInt(session.getAttribute("userId")+"");
             boolean actionResult = likeService.userLikeBlog(userId,blog.getBlogID()); 
             if (actionResult){
                 result.setstate(200);
                 result.setMessage("like action success");
             } else if (!actionResult){
                 result.setstate(499);
                 result.setMessage("like fail");
             }
            return  result; 
         
    }
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public  ErrorMessageDTO remove(@RequestBody int blogId,HttpSession session) {
            ErrorMessageDTO result = new ErrorMessageDTO(); 
             System.out.println(blogId); 
             int userId = Integer.parseInt(session.getAttribute("userId")+"");
             boolean actionResult = likeService.userUnlikeBlog(userId,blogId); 
             if (actionResult){
                 result.setstate(200);
                 result.setMessage("unlike action success");
             } else if (!actionResult){
                 result.setstate(499);
                 result.setMessage("unlike fail");
             }
            return  result; 
         
    }
}
