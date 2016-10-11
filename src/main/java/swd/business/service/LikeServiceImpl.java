package swd.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogDAO;
import swd.persistence.DAO.BlogLikeDAO;
import swd.persistence.entity.model.Bloglike;
import swd.persistence.entity.model.BloglikePK;
import swd.persistence.entity.model.Publishedblog;
@Transactional
@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private BlogLikeDAO blogLikeDAO;
    @Autowired
    private BlogDAO blogDAO;
    
    @Override
    public boolean userLikeBlog(int userId, int blogId) {
        Bloglike blogLike = new Bloglike();
        BloglikePK blogLikePK  = new BloglikePK();
        blogLikePK.setBlogID(blogId);
        blogLikePK.setUserID(userId);
        blogLike.setId(blogLikePK);
        boolean result =blogLikeDAO.create(blogLike);
        if (result){
            Publishedblog newBlog = blogDAO.getById(blogId); 
            newBlog.setNumberOfLike(newBlog.getNumberOfLike()+1);
            result = blogDAO.edit(blogId, newBlog);
        }
        return result;
    }

    @Override
    public boolean userUnlikeBlog(int userId, int blogId) {
        Bloglike blogLike = new Bloglike();
        BloglikePK blogLikePK  = new BloglikePK();
        blogLikePK.setBlogID(blogId);
        blogLikePK.setUserID(userId);
        blogLike.setId(blogLikePK);
        boolean result =blogLikeDAO.delete(blogLike);
        if (result){
            Publishedblog newBlog = blogDAO.getById(blogId); 
            newBlog.setNumberOfLike(newBlog.getNumberOfLike()-1);
            result = blogDAO.edit(blogId, newBlog);
        }
        return result; 
    }

    @Override
    public List<Bloglike> blogLikedByUser(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Bloglike> userLikeOfBlog(int blogId) {
        // TODO Auto-generated method stub
        return null;
    }

}
