package swd.business.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogCommentDao;
import swd.persistence.DAO.BlogDAO;
import swd.persistence.DAO.BlogLikeDAO;
import swd.persistence.DAO.UserDAO;
import swd.persistence.entity.model.Blogcategory;
import swd.persistence.entity.model.Blogcomment; 
import swd.persistence.entity.model.Publishedblog;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.CommentDTO;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private BlogCommentDao blogCommentDAO;
    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public boolean userCommentOnBlog(int userId, int BlogId, String content) {
        Blogcomment blComment = new Blogcomment();
        blComment.setContent(content);
        blComment.setCommentTime(new Date()); 
        blComment.setBlogID(BlogId);
        blComment.setUserID(userId); 
        boolean addResult =  blogCommentDAO.create(blComment);
        if (addResult){
            Publishedblog newBlog = blogDAO.getById(BlogId); 
            newBlog.setNumberOfComment(newBlog.getNumberOfComment()+1);
            addResult = blogDAO.edit(BlogId, newBlog);
        }
        return addResult;
    }

    @Override
    public List<Blogcomment> showCommentOfBlog(int blogId) {
        List<Blogcomment> listComment = blogCommentDAO.getCommentByBlogId(blogId);
        return listComment;
    }

    @Override
    public boolean removeCommentOnBlog(int commentId) {
        // TODO Auto-generated method stub
        
        boolean result  = blogCommentDAO.delete(commentId);
        
        return result;
    }

    @Override
    public boolean editCommentOnBlog(int userId, int BlogId, String content) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public CommentDTO convertToDTO(Blogcomment commentEnt) {
        CommentDTO commentDto = modelMapper.map(commentEnt, CommentDTO.class);
        User us = userDAO.getById(commentEnt.getUserID());
        commentDto.setAuthorName(us.getFullname());
        return commentDto; 
    }

    @Override
    public Blogcomment convertToEnt(CommentDTO commentDto) {
        // TODO Auto-generated method stub
        return null;
    }

}
