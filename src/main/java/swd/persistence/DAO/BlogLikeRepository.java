package swd.persistence.DAO;

import java.util.List;
import swd.persistence.entity.model.Bloglike;


public interface BlogLikeRepository {
    public boolean create(Bloglike blogLike);
    public boolean delete(Bloglike blogLike);
    public  List<Bloglike> findUserLikeByBlog(int blogId);
    public  List<Bloglike> showLikeOfUser(int userId);
}
