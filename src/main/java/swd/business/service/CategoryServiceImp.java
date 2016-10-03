package swd.business.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.CategoryDao;
import swd.persistence.entity.model.Category; 
import swd.presentation.DTO.CategoryDTO;
@Service
@Transactional
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryDao catDAO;
    @Override
    public List<Category> showAll() {
        List<Category> cats = catDAO.getAll();
        return cats;
    }

    @Override
    public Category getById(int catId) {
        Category cat = catDAO.getById(catId);
        return cat;
    }

    @Override
    public boolean create(Category newCat) {
        boolean existCheck = catDAO.CategoryExist(newCat.getName());
        boolean resultStatus = true;
        if (!existCheck){
            resultStatus = catDAO.create(newCat);
        }
        return resultStatus;
    }

    @Override
    public boolean removeById(int catId) {
        boolean resultStatus = catDAO.deleteById(catId);
        return resultStatus;
    }

    @Override
    public CategoryDTO convertToDTO(Category catEnt) {
        CategoryDTO catDto = modelMapper.map(catEnt, CategoryDTO.class);
        return catDto;
    }

    @Override
    public Category convertToEnt(CategoryDTO catDto) {
        Category catEnt = modelMapper.map(catDto, Category.class);
        return catEnt;
    }
    
}
