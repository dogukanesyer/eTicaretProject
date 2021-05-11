package eticaretProject.core.concretes;

import java.util.regex.Pattern;

import eticaretProject.core.abstracts.VerificationService;
import eticaretProject.entities.concretes.User;

public class VerificationManager implements VerificationService {

	public boolean isValidName(String name) {
		if (name == null || name.length() <= 2) {
			return false;
		}
		return true;
	}

	public boolean isValidEmail(String email) {
		String regexEmail = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regexEmail);
		if (email == null) {
			return false;
		}
		return pattern.matcher(regexEmail).matches();
	}

	public boolean isValidPassword(String password) {
		if (password == null || password.length() <= 6) {
			return false;
		}
		return true;

	}

	@Override
	public boolean isValid(User user) {
		if (!isValidEmail(user.geteMail())) {
			System.out.println("Yanlýþ email formatý.");
			return false;
		}
		if (!isValidName(user.getFirstName())) {
			System.out.println("Ýsminiz en az 2 karakterden oluþmalý.");
			return false;
		}
		if (!isValidName(user.getLastName())) {
			System.out.println("Soyadýnýz en az 2 karakterden oluþmalý.");
			return false;
		}
		if (!isValidPassword(user.getPassword())) {
			System.out.println("Þifre uzunluðunuz en az 6 karakterden oluþmalý.");
			return false;
		}
		return true;
	}

}
