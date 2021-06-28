package kodlamaiocum.northwindcim.business.concrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaiocum.northwindcim.business.abstracts.UserService;
import kodlamaiocum.northwindcim.core.dataAccess.UserDao;
import kodlamaiocum.northwindcim.core.entities.User;
import kodlamaiocum.northwindcim.core.utilities.results.DataResult;
import kodlamaiocum.northwindcim.core.utilities.results.Result;
import kodlamaiocum.northwindcim.core.utilities.results.SuccessDataResult;
import kodlamaiocum.northwindcim.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);	
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı Bulundu!");
	}

}
