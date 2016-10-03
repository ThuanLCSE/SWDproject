package swd.persistence.DAO;

import java.util.List;

import swd.persistence.entity.model.Blogcategory;


public interface BlogCategoryRepository {

	public boolean create(Blogcategory blogCategory);
	public boolean delete(Blogcategory blogCategory);
	public boolean updateInfor(Blogcategory blogCategory);
	public List<Blogcategory> getAll() ;
}
