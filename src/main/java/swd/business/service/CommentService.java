package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Blogcomment;

public interface CommentService {
    public boolean userCommentOnBlog(int userId, int BlogId, String content);
    public List<Blogcomment> showCommentOfBlog(int blogId);
    public boolean removeCommentOnBlog(int userId, int BlogId); 
    public boolean editCommentOnBlog(int userId, int BlogId, String content);
    
}
