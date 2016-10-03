package swd.persistence.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import swd.persistence.entity.model.Blogcategory;


public class BlogCategoryDao implements BlogCategoryRepository{

	@PersistenceContext
    private EntityManager em;
	@Override
	public boolean create(Blogcategory blogCategory) {
		Blogcategory blc = em.find(Blogcategory.class, blogCategory.getId());
		if (blc==null) {
			em.persist(blogCategory);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Blogcategory blogCategory) {
		Blogcategory blc = em.find(Blogcategory.class, blogCategory.getId());
        if (blc != null){
            em.remove(blogCategory);
            return true;
            }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfor(Blogcategory blogCategory) {
		if (em.find(Blogcategory.class, blogCategory.getId())!=null){
            em.merge(blogCategory);
            return true;
        }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Blogcategory> getAll() {
		 List<Blogcategory> Blogcategory = em.createQuery("Select a From User a", Blogcategory.class).getResultList();
	        return Blogcategory;
	}

}
