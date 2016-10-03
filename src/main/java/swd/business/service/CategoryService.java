package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Category;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CategoryDTO;

public interface CategoryService {
    public List<Category> showAll();
    public Category getById(int catId);
    public boolean create(Category newCat);
    public boolean removeById(int catId);
   
    public CategoryDTO convertToDTO(Category catEnt); 
    public Category convertToEnt(CategoryDTO catDto);
  
}
