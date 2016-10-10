package swd.business.service;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swd.persistence.DAO.UserDAO;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.UserDTO;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserDAO userDao;
    public User getUserById(int userId){
        User us = userDao.getById(userId);
        return us;
    }
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
            System.out.println(user.getFullname());

            System.out.println(user.getUsername());
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
        boolean result = userDao.checkLogin(username, password);
        return result;
    }

    @Override
    public User getAuthorized(String username) {
        
        // TODO Auto-generated method stub
        return userDao.getByUsername(username);
    }
    @Override
    public UserDTO convertToDTO(User userEnt) {
        UserDTO userDto = modelMapper.map(userEnt, UserDTO.class);
        return userDto;
    }
    @Override
    public User convertToEnt(UserDTO userDto) {
        User  userEnt = modelMapper.map(userDto, User.class); 
        return userEnt;
    }
    @Override
    public boolean editUserById(int userId, User userEnt) {
        boolean usernameExist = userDao.usernameExist(userEnt.getUsername());
        if (!usernameExist){
            return false;
        } else {
            boolean result =  userDao.updateInfo(userEnt); 
            return result;
        }
    }
    @Override
    public boolean deactiveUser(int userId) {
        // TODO Auto-generated method stub
        return false;
    }
	public User getUserByUsername(String username) {
		User us = userDao.getByUsername(username);
        return us;
		// TODO Auto-generated method stub
	}
}
