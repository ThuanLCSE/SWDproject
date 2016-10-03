package swd.persistence.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.entity.model.Category;




@Repository
@Transactional
public class CategoryDao implements CategoryRepository{

	@PersistenceContext
	private EntityManager em;

	public boolean CategoryExist(String categoryName) {
		Query q = em.createQuery("select c from Cat c where c.name = :name");
		q.setParameter("name", categoryName);
		try {
			Category tmp = (Category) q.getSingleResult();
			if (tmp.getName().equals(categoryName)) {
				return true;
			}
		} catch (NoResultException e) {
			return false;
		}
		return false;
	}

	public boolean create(Category Category) {
		em.persist(Category);
		return true;
	}
    public boolean deleteById(int CategoryID) {
        Category catagory =em.find(Category.class, CategoryID);
        if (catagory != null){
            em.remove(catagory);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        
    }
    public List<Category> getAll() {
        List<Category> catagory = em.createQuery("Select a From Category a", Category.class).getResultList();
        return catagory;
    }
//
//	@Override
//	public boolean updateInfo(Category category) {
//		
//		if (em.find(Category.class, category.getCategoryID())!=null){
//            em.merge(category);
//            return true;
//        }
//		// TODO Auto-generated method stub
//		return false;
//	}

    @Override
    public Category getById(int categoryId) {
        Category category =em.find(Category.class, categoryId);
        return category;
    }
}
