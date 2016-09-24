package swd.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.entity.model.Bloglike;
import swd.entity.model.User;

@Repository
@Transactional
public class BlogLikeDAO {
    @PersistenceContext
    private EntityManager em;
    
    public boolean create(Bloglike blogLike){
        Bloglike bl = em.find(Bloglike.class, blogLike.getId());
        if (bl == null){
            em.persist(blogLike);
            return true;
        }
        return false;
    }
    public boolean delete(Bloglike blogLike){
        Bloglike bl = em.find(Bloglike.class, blogLike.getId());
        if (bl != null){
            em.remove(blogLike);
            return true;
        }
        return false;
    }
    public  List<Bloglike> showLikeOfBlog(int blogId){
        String jpql = "Select b From Bloglike b"
                + "Where b.blogId = :blogId";
        Query query = em.createQuery(jpql);
        query.setParameter("blogId", blogId);
        List<Bloglike> likes = query.getResultList();
        return likes;
    }
    public  List<Bloglike> showLikeOfUser(int userId){
        String jpql = "Select b From Bloglike b"
                + "Where b.userId = :userId";
        Query query = em.createQuery(jpql);
        query.setParameter("userId", userId);
        List<Bloglike> likes = query.getResultList();
        return likes;
    }
}
