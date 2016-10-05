package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/detail/{blogId}")
    public BlogDTO detail(@RequestBody String accessToken, @PathVariable int blogId) {
        System.out.println(accessToken);
        Publishedblog blogEnt =  blogService.findById(blogId);
        BlogDTO blogDto = blogService.convertToDTO(blogEnt);
        return  blogDto;
    }
    @RequestMapping("/all")
    public List<BlogDTO> greeting(@RequestBody String accessToken) {
         if (accessToken == null){
             return null;
         } else {
             System.out.println(accessToken);
             List<Publishedblog> blogEnts= blogService.showAll();
             List<BlogDTO> blogDTOs  = new ArrayList<BlogDTO>();
             for (Publishedblog blogEnt: blogEnts){
                 BlogDTO blogDTO = blogService.convertToDTO(blogEnt);
                 blogDTOs.add(blogDTO);
             } 
             System.out.println(blogDTOs.get(0));
            return  blogDTOs;
         }
    }
    @RequestMapping("/create")
    public  boolean create(@RequestBody BlogDTO blogDto,@RequestBody String accessToken) {
         if (accessToken == null){
             return false;
         } else {
             System.out.println(accessToken);
             Publishedblog blogEnt = blogService.convertToEnt(blogDto);
             boolean result = blogService.saveBlog(blogEnt);
             System.out.println(blogEnt);
            return  result;
         }
    }
}
