package eticaretProject;

import eticaretProject.business.abstracts.UserService;
import eticaretProject.business.concretes.UserManager;
import eticaretProject.core.concretes.GoogleUserVerificationAdapter;
import eticaretProject.core.concretes.ValidatorManager;
import eticaretProject.core.concretes.VerificationManager;
import eticaretProject.dataAccess.concretes.UserDao;
import eticaretProject.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Do�ukan", "E�yer", "dogukanesyer@gmail.com", "12345");
		User user2 = new User(2, "Onur", "Y�lmaz", "onuryilmaz@gmail.com", "19361");
		User user3 = new User(3, "Mert", "T�rko�lu", "mertturkoglu@gmail.com", "67895");

		UserService service = new UserManager(new VerificationManager(), new UserDao(), new ValidatorManager());

		System.out.println("Kay�t ba�ar�l�");
		System.out.println("----------");
		service.register(user1);
		service.login(user1.geteMail(), user1.getPassword());

		System.out.println("Kay�t ba�ar�l�");
		System.out.println("----------");
		service.register(user2);
		service.login(user2.geteMail(), user2.getPassword());

		UserService service2 = new UserManager(new GoogleUserVerificationAdapter(), new UserDao(), new ValidatorManager());
		
		System.out.println("Google kayd� ba�ar�l�");
		System.out.println("----------");
		service.register(user3);
		service.login(user3.geteMail(), user3.getPassword());
	}

}
