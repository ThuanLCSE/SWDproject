package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;

public interface BlogService {
    public List<Publishedblog> showAll();
    public Publishedblog findById(int blogId);
    public boolean saveAsDraft(Publishedblog blog);
    public boolean publishBlogById(int blogId);
    public boolean saveBlog(Publishedblog blog);
    public boolean editBlog(Publishedblog blog);
    public boolean updateCommentById(int blogId, int commentAmount);
    public boolean updateLiketById(int blogId, int likeAmount);
    public boolean deleteBlogById(int blogId);
    public BlogDTO convertToDTO(Publishedblog blogEnt);
    public Publishedblog convertToEnt(BlogDTO blogDto);
}
