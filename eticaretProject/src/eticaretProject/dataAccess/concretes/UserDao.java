package eticaretProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eticaretProject.dataAccess.abstracts.UserDaoService;
import eticaretProject.entities.concretes.User;

public class UserDao implements UserDaoService{
	List<User> users=new ArrayList<>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName()+" "+user.getLastName()+" kullanýcýsý kayýt edildi.");
		
			
		
		
	}

	@Override
	public boolean checkEmail(User user) {
		for(User u:users) {
			if(u.geteMail()==user.geteMail()) {
				return true;
			}
		}
		return false;
				
	}

	@Override
	public boolean logincheck(String email, String password) {
		for(User u:users) {
			if (u.geteMail()==email&&u.getPassword()==password) {
				return true;
			}
		}
		return false;
	}

}
