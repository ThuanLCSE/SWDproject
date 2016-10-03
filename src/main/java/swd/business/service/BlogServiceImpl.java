package swd.business.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.BlogDAO;
import swd.persistence.entity.model.Publishedblog;
import swd.presentation.DTO.BlogDTO;
@Transactional
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BlogDAO blogDao;
  
    @Override
    public List<Publishedblog> showAll() {
        
        return blogDao.getAll();
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
    	Publishedblog temp= blogDao.getById(blog.getBlogID());
    	if (temp==null) {
			blogDao.create(blog);
			return true;
		}
        return false;
    }

    @Override
    public boolean editBlog(Publishedblog blog) {
    	Publishedblog temp= blogDao.getById(blog.getBlogID());
    	if (temp!=null) {
			blogDao.edit(blog.getBlogID(), blog);
			return true;
		}
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
        System.out.println(blogDto);
        return blogDto;
    }

    @Override
    public Publishedblog convertToEnt(BlogDTO blogDto) {
        Publishedblog blogEnt = modelMapper.map(blogDto, Publishedblog.class);
        return blogEnt;
    }
  
}
