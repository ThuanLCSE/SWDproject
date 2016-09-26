package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Bloglike;

public interface LikeService {
    public boolean userLikeBlog(int userId, int blogId);
    public boolean userUnlikeBlog(int userId, int blogId);
    public List<Bloglike> blogLikedByUser(int userId);
    public List<Bloglike> userLikeOfBlog(int blogId);
}
