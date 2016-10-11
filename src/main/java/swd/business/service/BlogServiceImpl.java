package swd.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogDAO;
import swd.persistence.DAO.UserDAO;
import swd.persistence.entity.model.Publishedblog;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.BlogDTO;
@Transactional
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BlogDAO blogDao;
    @Autowired
    private UserDAO UserDAO;
    @Override
    public List<Publishedblog> showAll() {
        List<Publishedblog> blogs = blogDao.getAll();
        List<Publishedblog> result = new ArrayList<Publishedblog>();
        for (int i=0;i<blogs.size();i++){
            if (blogs.get(i).getPublished() == 1){
                result.add(blogs.get(i));
            }
        }
        return result;
    }

    @Override
    public boolean saveAsDraft(Publishedblog blog) {
        Publishedblog publishedblog = blog;
        publishedblog.setLastUpdateDay(new Date());
        publishedblog.setNumberOfComment(0);
        publishedblog.setNumberOfLike(0);
        publishedblog.setPublished((byte)0);
        publishedblog.setPublishedDay(new Date()); 
        boolean result = blogDao.create(publishedblog);
        return result;
    }
    

    @Override
    public boolean publishBlogById(int blogId) {
        Publishedblog current = blogDao.getById(blogId); 
        current.setPublished((byte)1);
        boolean result=  blogDao.edit(blogId, current); 
        return result; 
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
    	Publishedblog blog = blogDao.getById(blogId);
    	if (blog!=null) {
			blogDao.removeBLog(blogId);
			return true;
		}
    	
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Publishedblog findById(int blogId) {
        Publishedblog blog = blogDao.getById(blogId);
        return blog;
    }

    @Override
    public  BlogDTO convertToDTO(Publishedblog blogEnt) { 
        BlogDTO blogDto = modelMapper.map(blogEnt, BlogDTO.class); 
        return blogDto;
    }

    @Override
    public Publishedblog convertToEnt(BlogDTO blogDto) {
        Publishedblog blogEnt = modelMapper.map(blogDto, Publishedblog.class);
        return blogEnt;
    }

	@Override
	public boolean saveBlog(String title, String picture, String content) {
		Publishedblog publishedblog = new Publishedblog();
		publishedblog.setContent(content);
		publishedblog.setImageUrl(picture);
		publishedblog.setTitle(title);
		publishedblog.setLastUpdateDay(new Date());
		publishedblog.setNumberOfComment(0);
		publishedblog.setNumberOfLike(0);
		publishedblog.setPublished((byte)1);
		publishedblog.setPublishedDay(new Date());
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();  
        User us = UserDAO.getByUsername(username);  
		publishedblog.setUserID(us.getUserID());
		publishedblog.setAuthorName(us.getFullname());
		blogDao.create(publishedblog);
		return true;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean editBlog(Publishedblog blog) {
	    Publishedblog current = blogDao.getById(blog.getBlogID());
	    current.setTitle(blog.getTitle());
	    current.setContent(blog.getContent());
	    current.setImageUrl(blog.getImageUrl()); 
		boolean result=  blogDao.edit(blog.getBlogID(), current); 
		return result;
	}

    @Override
    public boolean saveBlogByDto(Publishedblog blog) {
        Publishedblog publishedblog = blog;
        publishedblog.setLastUpdateDay(new Date());
        publishedblog.setNumberOfComment(0);
        publishedblog.setNumberOfLike(0);
        publishedblog.setPublished((byte)1);
        publishedblog.setPublishedDay(new Date()); 
        boolean result = blogDao.create(publishedblog);
        return result;
    }

    @Override
    public List<Publishedblog> showAllByUserId(int userId) {
        List<Publishedblog> temp =blogDao.getAll();
        List<Publishedblog> result = new ArrayList<Publishedblog>();
        for (int i=0;i<temp.size();i++ ){
            if (temp.get(i).getUserID() == userId  && temp.get(i).getPublished() == 1){
                result.add(temp.get(i));
            }
        }
        return result;
        
    }

    @Override
    public boolean unpublishBlogById(int blogId) {
        Publishedblog current = blogDao.getById(blogId); 
        current.setPublished((byte)0);
        boolean result=  blogDao.edit(blogId, current); 
        return result; 
    }

    @Override
    public List<Publishedblog> showAllDraftByUserId(int userId) {
        List<Publishedblog> temp =blogDao.getAll();
        List<Publishedblog> result = new ArrayList<Publishedblog>();
        for (int i=0;i<temp.size();i++){
            if (temp.get(i).getUserID() == userId && temp.get(i).getPublished() == 0){
                result.add(temp.get(i));
            }
        }
        return result; 
    }

	
  
}
