package swd.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.entity.model.Blogcomment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Override
    public boolean userCommentOnBlog(int userId, int BlogId, String content) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Blogcomment> showCommentOfBlog(int blogId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeCommentOnBlog(int userId, int BlogId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean editCommentOnBlog(int userId, int BlogId, String content) {
        // TODO Auto-generated method stub
        return false;
    }

}
