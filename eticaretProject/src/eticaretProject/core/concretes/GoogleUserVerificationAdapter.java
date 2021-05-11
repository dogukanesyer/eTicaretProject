package eticaretProject.core.concretes;

import eticaretProject.core.abstracts.VerificationService;
import eticaretProject.entities.concretes.User;
import eticaretProject.googleUserValidationService.GoogleVerificationService;

public class GoogleUserVerificationAdapter implements VerificationService{


	@Override
	public boolean isValid(User user) {
		GoogleVerificationService googleUserValid=new GoogleVerificationService();
		return googleUserValid.isValidGoogle();
	}

}
