package kodlamaiocum.northwindcim.business.abstracts;

import kodlamaiocum.northwindcim.core.entities.User;
import kodlamaiocum.northwindcim.core.utilities.results.DataResult;
import kodlamaiocum.northwindcim.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
