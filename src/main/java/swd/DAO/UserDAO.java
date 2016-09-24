package swd.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swd.entity.model.User;
@Repository
@Transactional
public class UserDAO{
    @PersistenceContext
    private EntityManager em;
    
    
    public User checkLogin(String username, String password) {
        String jpql = "Select u From User u"
                + "Where u.username = :username And u.password = :password";
        Query query = em.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        return user;
    }

    public boolean updateInfo(User user) {
        if (em.find(User.class, user.getUserID())!=null){
            em.merge(user);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        
    }
    public boolean usernameExist(String username){
        Query q = em.createQuery("select c from Cat c where c.name = :name");
        q.setParameter("name", username);
        try {
        User tmp = (User) q.getSingleResult();
        if (tmp.getUsername().equals(username)){
            return true;
        }
        } catch (NoResultException e){
            return false;
        }
        return false;
    }
    public boolean create(User user) {
        em.persist(user);
        return true;
    }

    public boolean deactivate(int userId) {
        User user =em.find(User.class, userId);
        if (user != null){
            user.setActive((byte) 0);
            em.merge(user);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        
    }
    public boolean delete(int userId) {
        User user =em.find(User.class, userId);
        if (user != null){
            em.remove(user);
            return true;
        }
        return false;
        // TODO Auto-generated method stub
        
    }

    public List<User> getAll() {
        List<User> users = em.createQuery("Select a From User a", User.class).getResultList();
        return users;
    }
    
}
