package eticaretProject.business.concretes;

import eticaretProject.business.abstracts.UserService;
import eticaretProject.core.abstracts.ValidatorService;
import eticaretProject.core.abstracts.VerificationService;
import eticaretProject.dataAccess.abstracts.UserDaoService;
import eticaretProject.entities.concretes.User;

public class UserManager implements UserService {

	VerificationService verificationService;
	UserDaoService userDaoService;
	ValidatorService validatorService;

	public UserManager(VerificationService verificationService, UserDaoService userDaoService,
			ValidatorService validatorService) {

		this.verificationService = verificationService;
		this.userDaoService = userDaoService;
		this.validatorService = validatorService;
	}

	@Override
	public void register(User user) {
		if (!verificationService.isValid(user)) {
			System.out.println("Kay�t ba�ar�s�z. �stenilen �artlara uymad�n�z.");
		}else if(!userDaoService.checkEmail(user)) {
			System.out.println("Bu email adresi al�nm��t�r. Farkl� bir email adresi giriniz.");
		}else {
			userDaoService.add(user);
			validatorService.verificationMail();
		}
		
	}

	@Override
	public void login(String email, String password) {
		if (userDaoService.logincheck(email, password)) {
			System.out.println("Giri� ba�ar�l�.");
		} else {
			System.out.println("Giri� ba�ar�s�z");

		}

	}

}
