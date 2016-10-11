package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Blogcomment;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.CommentDTO;

public interface CommentService {
    public boolean userCommentOnBlog(int userId, int BlogId, String content);
    public List<Blogcomment> showCommentOfBlog(int blogId);
    public boolean removeCommentOnBlog(int commentId); 
    public boolean editCommentOnBlog(int userId, int BlogId, String content);
    public CommentDTO convertToDTO(Blogcomment commentEnt);
    public Blogcomment convertToEnt(CommentDTO commentDto);
    
}
