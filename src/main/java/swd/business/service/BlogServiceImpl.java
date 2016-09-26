package swd.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogDAO;
import swd.persistence.entity.model.Publishedblog;
@Transactional
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogDAO blogDao;
  
    @Override
    public List<Publishedblog> showAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean saveAsDraft(Publishedblog blog) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean publishBlogById(int blogId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean saveBlog(Publishedblog blog) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean editBlog(Publishedblog blog) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateCommentById(int blogId, int commentAmount) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateLiketById(int blogId, int likeAmount) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteBlogById(int blogId) {
        // TODO Auto-generated method stub
        return false;
    }

}
