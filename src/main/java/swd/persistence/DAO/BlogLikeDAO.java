package swd.persistence.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.entity.model.Bloglike;

@Repository
@Transactional
public class BlogLikeDAO implements BlogLikeRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public boolean create(Bloglike blogLike){
        Bloglike bl = em.find(Bloglike.class, blogLike.getId());
        if (bl == null){
            em.persist(blogLike);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(Bloglike blogLike){
        Bloglike bl = em.find(Bloglike.class, blogLike.getId());
        if (bl != null){
            em.remove(blogLike);
            return true;
        }
        return false;
    }
    @Override
    public  List<Bloglike> findUserLikeByBlog(int blogId){
        String jpql = "Select b From Bloglike b"
                + "Where b.blogId = :blogId";
        Query query = em.createQuery(jpql);
        query.setParameter("blogId", blogId);
        List<Bloglike> likes = query.getResultList();
        return likes;
    }
    @Override
    public  List<Bloglike> showLikeOfUser(int userId){
        String jpql = "Select b From Bloglike b"
                + "Where b.userId = :userId";
        Query query = em.createQuery(jpql);
        query.setParameter("userId", userId);
        List<Bloglike> likes = query.getResultList();
        return likes;
    } 
}
