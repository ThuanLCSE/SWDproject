package swd.business.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.UserDAO;
import swd.persistence.entity.model.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
  
    public void setUserDAO(UserDAO userDAO){
        this.userDao = userDAO;
    }
    
    public boolean signUp(String username, String password, String fullName){

        boolean usernameExist = userDao.usernameExist(username);
        if (usernameExist){
            return false;
        } else {
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
            return true;
        }   
        
    }

    @Override
    public List<User> getAllUser() {
        
        return  userDao.getAll();
    }

    @Override
    public boolean getAuthenticated(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User getAuthorized(String username) {
        
        // TODO Auto-generated method stub
        return userDao.getByUsername(username);
    }
}
