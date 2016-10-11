package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 







import swd.business.service.CommentService;
import swd.persistence.entity.model.Blogcomment;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CommentDTO;
import swd.presentation.DTO.ErrorMessageDTO;

@RestController
@RequestMapping("/api/comment")
public class RestCommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  ErrorMessageDTO create(@RequestBody CommentDTO comment, HttpSession session) {
            ErrorMessageDTO result = new ErrorMessageDTO();  
             int userId = Integer.parseInt(session.getAttribute("userId")+"");
           
             boolean actionResult = commentService.userCommentOnBlog(userId, comment.getBlogId(), comment.getContent());
             if (actionResult){
                 result.setstate(200);
                 result.setMessage("comment action success");
             } else if (!actionResult){
                 result.setstate(499);
                 result.setMessage("comment fail");
             }
            return  result; 
         
    }
    @RequestMapping(value = "/remove/{commentId}", method = RequestMethod.POST)
    public  ErrorMessageDTO create(@PathVariable int commentId, HttpSession session) {
            ErrorMessageDTO result = new ErrorMessageDTO();   
             boolean actionResult = commentService.removeCommentOnBlog(commentId);
             if (actionResult){
                 result.setstate(200);
                 result.setMessage("remove comment action success");
             } else if (!actionResult){
                 result.setstate(499);
                 result.setMessage("remove comment fail");
             }
            return  result; 
         
    }
    @RequestMapping(value = "/listComment/{blogId}", method = RequestMethod.POST)
    public List<CommentDTO> getList(@PathVariable int blogId) {
        List<Blogcomment> listComment = commentService.showCommentOfBlog(blogId);
        List<CommentDTO> result = new ArrayList<CommentDTO>();
        for (Blogcomment comment: listComment){
            CommentDTO commentDto = commentService.convertToDTO(comment);
            result.add(commentDto);
        }  
        return result;
    }
}
