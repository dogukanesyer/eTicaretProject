package eticaretProject.core.abstracts;

import eticaretProject.entities.concretes.User;

public interface VerificationService {
	boolean isValid(User user);
}
