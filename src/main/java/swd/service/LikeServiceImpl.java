package swd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import swd.DAO.BlogLikeDAO;
import swd.entity.model.Bloglike;

public class LikeServiceImpl implements LikeService{
    @Autowired
    private BlogLikeDAO blogLikeDAO;
    
    @Override
    public boolean userLikeBlog(int userId, int blogId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean userUnlikeBlog(int userId, int blogId) {
        // TODO Auto-generated method stub
        return false;
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
