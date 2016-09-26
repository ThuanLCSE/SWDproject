package swd.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import swd.persistence.entity.model.Publishedblog;

public interface BlogRepository extends JpaRepository<Publishedblog, Integer>{

}
