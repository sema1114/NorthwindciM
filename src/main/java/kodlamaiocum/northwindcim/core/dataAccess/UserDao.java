package kodlamaiocum.northwindcim.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaiocum.northwindcim.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{

	User findByEmail(String email);//email kontrolu sağlama
}
