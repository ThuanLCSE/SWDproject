package swd.persistence.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import swd.persistence.entity.model.Publishedblog;


@Repository
@Transactional
public class BlogDAO{
    @PersistenceContext
    private EntityManager em;
    
    public List<Publishedblog> getAll(){
        
        List<Publishedblog> blogs = em.createQuery("Select b From Publishedblog b", Publishedblog.class).getResultList();
        return blogs;
    }
    public boolean create(Publishedblog blog){
        em.persist(blog);
        return true;
    }
    public boolean removeBLog(int blogId){
        Publishedblog blog = em.find(Publishedblog.class, blogId);
        if (blog != null){
            em.remove(blog);
            return true;
        }
        return false;
    }
    public boolean edit(int blogId, Publishedblog newBlog){
        Publishedblog blog = em.find(Publishedblog.class, blogId);
        if (blog != null){
            blog.setContent(newBlog.getContent());
            blog.setImageUrl(newBlog.getImageUrl());
            blog.setLastUpdateDay(newBlog.getLastUpdateDay());
            blog.setPublished(newBlog.getPublished());
            blog.setPublishedDay(newBlog.getPublishedDay());
            blog.setTitle(newBlog.getTitle());
            em.merge(blog);
            return true;
        }
        return false;
    }
}
