package swd.persistence.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.entity.model.Blogcomment;


@Repository
@Transactional
public class BlogCommentDao implements BlogCommentRepository{

	@PersistenceContext
    private EntityManager em;
	@Override
	public boolean create(Blogcomment blogComment) {
		Blogcomment blc = em.find(Blogcomment.class, blogComment.getId());
		if (blc==null) {
			em.persist(blogComment);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Blogcomment blogComment) {
		Blogcomment blc = em.find(Blogcomment.class, blogComment.getId());
        if (blc != null){
            em.remove(blogComment);
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

}
