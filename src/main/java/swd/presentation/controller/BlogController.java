package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import swd.business.service.BlogService; 
import swd.business.service.CategoryService;
import swd.business.service.UserService;
import swd.persistence.DAO.UserDAO;
import swd.persistence.entity.model.Category;
import swd.persistence.entity.model.Publishedblog;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CategoryDTO;


@Controller
public class BlogController {

 
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService catService;
    /**
     * view all
     */
    @RequestMapping(value={"/blogs"}, method = RequestMethod.GET)
    public ModelAndView viewAllBlog() {
        ModelAndView mv= new ModelAndView();
        List<Publishedblog> blogEnts= blogService.showAll();
        List<BlogDTO> blogDTOs  = new ArrayList<BlogDTO>();
        for (Publishedblog blogEnt: blogEnts){
            BlogDTO blogDTO = blogService.convertToDTO(blogEnt);
            blogDTOs.add(blogDTO);
        }
        List<Category> catEnts = catService.showAll();
        List<CategoryDTO> catDTOs = new ArrayList<CategoryDTO>();
        for (Category catEnt: catEnts){
            CategoryDTO catDto = catService.convertToDTO(catEnt);
            catDTOs.add(catDto);
        }
        System.out.println(catDTOs);
        mv.addObject("categories", catDTOs);
        mv.addObject("blogs", blogDTOs);
        mv.setViewName("listBlog");
        return mv;
    }
    /**
     * view my blog
     */
    @RequestMapping(value={"/listBlog"}, method = RequestMethod.GET)
    public ModelAndView viewMyBlog() {
    	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();  
        User us = userService.getAuthorized(username);  
        
        ModelAndView mv= new ModelAndView();
        List<Publishedblog> blogEnts= blogService.showAllByUserId(us.getUserID());
        List<BlogDTO> blogDTOs  = new ArrayList<BlogDTO>();
        for (Publishedblog blogEnt: blogEnts){ 
        	BlogDTO blogDTO = blogService.convertToDTO(blogEnt);
            	blogDTOs.add(blogDTO);
        }
        List<Category> catEnts = catService.showAll();
        List<CategoryDTO> catDTOs = new ArrayList<CategoryDTO>();
        for (Category catEnt: catEnts){ 
            	CategoryDTO catDto = catService.convertToDTO(catEnt);
            	catDTOs.add(catDto); 
        }
        System.out.println(catDTOs);
        mv.addObject("categories", catDTOs);
        mv.addObject("blogs", blogDTOs);
        mv.setViewName("listBlog");
        return mv;
    }
  
    @RequestMapping(value ="/CreateBlog", method = RequestMethod.GET)
    public String createBlogg(){ 
        return "CreateBlog";
    }
    @RequestMapping(value={"/CreateBlog"}, method = RequestMethod.POST)
    public String createBlog(Model model, @RequestParam String title, @RequestParam String picture,
            @RequestParam String content){
    	blogService.saveBlog(title, picture, content);
    	return "redirect:/listBlog/";
    }
     @RequestMapping(value={"/blogApp"}, method = RequestMethod.GET)
        public String appBlog() {
            return "blogLayout";
        }
      
}
