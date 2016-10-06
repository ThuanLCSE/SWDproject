package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swd.business.service.BlogService;
import swd.persistence.entity.model.Category;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CategoryDTO;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController { 
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/detail/{blogId}", method = RequestMethod.POST)
    public BlogDTO detail(HttpSession session, @PathVariable int blogId) {
        System.out.println(session.getAttribute("userId"));
        Publishedblog blogEnt =  blogService.findById(blogId);
        BlogDTO blogDto = blogService.convertToDTO(blogEnt);
        return  blogDto;
    }
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<BlogDTO> greeting(HttpSession session) {
//         if (accessToken == null){
//             return null;
//         } else {
             System.out.println(session.getAttribute("userId"));
             List<Publishedblog> blogEnts= blogService.showAll();
             List<BlogDTO> blogDTOs  = new ArrayList<BlogDTO>();
             for (Publishedblog blogEnt: blogEnts){
                 BlogDTO blogDTO = blogService.convertToDTO(blogEnt);
                 blogDTOs.add(blogDTO);
             } 
             System.out.println(blogDTOs.get(0));
            return  blogDTOs;
//         }
    }
//    @RequestMapping(value = "/all/{userId}", method = RequestMethod.POST)
//    public List<BlogDTO> blogOfUser(HttpSession session, @PathVariable int userId) {
//  
//             List<Publishedblog> blogEnts= blogService.;
//             List<BlogDTO> blogDTOs  = new ArrayList<BlogDTO>();
//             for (Publishedblog blogEnt: blogEnts){
//                 BlogDTO blogDTO = blogService.convertToDTO(blogEnt);
//                 blogDTOs.add(blogDTO);
//             } 
//             System.out.println(blogDTOs.get(0));
//            return  blogDTOs;
// 
//    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  boolean create(@RequestBody BlogDTO blogDto,HttpSession session) {
       
             System.out.println(blogDto.toString());
//             Publishedblog blogEnt = blogService.convertToEnt(blogDto);
//             boolean result = blogService.saveBlog(blogEnt);
//             System.out.println(blogEnt);
//            return  result;
             return true;
         
    }
}
