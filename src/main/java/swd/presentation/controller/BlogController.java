package swd.presentation.controller;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swd.business.service.BlogService; 
import swd.business.service.CategoryService;
import swd.persistence.entity.model.Category;
import swd.persistence.entity.model.Publishedblog; 
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CategoryDTO;


@Controller
public class BlogController {

 
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService catService;
    
    @RequestMapping(value={"/blogs"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
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
  
}
