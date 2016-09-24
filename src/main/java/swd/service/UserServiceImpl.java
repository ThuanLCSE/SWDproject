package swd.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import swd.DAO.UserDAO;
import swd.entity.model.User;

@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
  
    public void setUserDAO(UserDAO userDAO){
        this.userDao = userDAO;
    }
    
    public void signUp(String username, String password, String fullName){
        User user = new User();
        
        user.setActive((byte) 1);
       
        user.setCreateDay(new Date());
        user.setRole("author");
        user.setTotalBlog(0);
        user.setUsername(username);
        user.setFullname(fullName);
        user.setPassword(password);
        user.setProfilePictureUrl("");
        userDao.create(user);
    }

    @Override
    public List<User> getAllUser() {
        
        return  userDao.getAll();
    }
}
