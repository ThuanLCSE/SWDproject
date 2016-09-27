package swd.persistence.DAO;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;

import swd.persistence.entity.model.Bloglike;
import swd.persistence.entity.model.Publishedblog;

public interface BlogLikeRepository {
    public boolean create(Bloglike blogLike);
    public boolean delete(Bloglike blogLike);
    public  List<Bloglike> findUserLikeByBlog(int blogId);
    public  List<Bloglike> showLikeOfUser(int userId);
}
