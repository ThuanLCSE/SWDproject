package swd.persistence.DAO;

import java.util.List;

import swd.persistence.entity.model.Category;


public interface CategoryRepository {

	public boolean CategoryExist(String categoryName);

	public boolean create(Category Category);
	public boolean updateInfo(Category category);

	public boolean delete(int CategoryID);

	public List<Category> getAll();
}
