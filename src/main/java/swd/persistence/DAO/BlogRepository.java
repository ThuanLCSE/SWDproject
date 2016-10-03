package swd.persistence.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import swd.persistence.entity.model.Publishedblog;

public interface BlogRepository {
    public List<Publishedblog> getAll();
    public Publishedblog getById(int blogId);
    
    public boolean create(Publishedblog blog);
    public boolean removeBLog(int blogId);
    public boolean edit(int blogId, Publishedblog newBlog);
}
