package eticaretProject.dataAccess.abstracts;

import eticaretProject.entities.concretes.User;

public interface UserDaoService {
	void add(User user);
	boolean checkEmail(User user);
	boolean logincheck(String email, String password);
}
