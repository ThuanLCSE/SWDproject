package swd.persistence.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.entity.model.Blogcomment;
import swd.persistence.entity.model.Publishedblog;


@Repository
@Transactional
public class BlogCommentDao implements BlogCommentRepository{

	@PersistenceContext
    private EntityManager em;
	@Override
	public boolean create(Blogcomment blogComment) { 
			em.persist(blogComment);
			return true; 
	}

	@Override
	public boolean delete(int commentId) {
		Blogcomment blc = em.find(Blogcomment.class, commentId);
        if (blc != null){
            em.remove(blc);
            return true;
            }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfor(Blogcomment blogComment) {
		if (em.find(Blogcomment.class, blogComment.getId())!=null){
            em.merge(blogComment);
            return true;
        }
        return false;
		// TODO Auto-generated method stub
	}

    @Override
    public List<Blogcomment> getCommentByBlogId(int blogId) {
        
        String jpql = "Select c From Blogcomment c "
                + "Where c.blogID = :blogId";
        Query query = em.createQuery(jpql);
        query.setParameter("blogId", blogId); 
        List<Blogcomment> result = query.getResultList();
        return result;
    }

}
