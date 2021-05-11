package eticaretProject.business.abstracts;

import eticaretProject.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(String email, String password);
}
