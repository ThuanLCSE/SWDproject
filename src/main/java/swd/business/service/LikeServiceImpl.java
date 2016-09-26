package swd.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogLikeDAO;
import swd.persistence.entity.model.Bloglike;
@Transactional
@Service
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
