import java.util.ArrayList;

public class PasswordCheckerUtility {

	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		int status = 0;
		
		// check if every method results doesn't throw an exception
		try {
			if (isValidLength(password)) {
				status++;
			}
			if (hasUpperAlpha(password)) {
				status++;
			}
			if (hasLowerAlpha(password)) {
				status++;
			}
			if (hasDigit(password)) {
				status++;
			}
			if (hasSpecialChar(password)) {
				status++;
			}
			if (noSameCharInSequence(password)) {
				status++;
			}
		}
		finally {
			
		}
		
		if (status == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		int status = 0;
		
		// if status = 1, the password is between 6 and 9 characters
		try {
			if (!hasBetweenSixAndNineChars(password)) {
				status++;
			}
		}
		finally {
			
		}
		
		// return results
		if (status == 1) {
			return false;
		}
		else {
			throw new WeakPasswordException();
		}
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		String temp = "";
		
		// check every password's validity and appends it to the new ArrayList
		for (int i = 0; i < passwords.size(); i++) {
			try {
				temp = passwords.get(i);
				isValidPassword(temp);
			}
			catch (Exception e) {
				invalidPasswords.add(temp + " " + e.getMessage());
				temp = "";
			}
		}
		
		return invalidPasswords;
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		if (password.equals(passwordConfirm)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isValidLength(String password) throws LengthException{
		if (password.length() >= 6) {
			return true;
		}
		else {
			throw new LengthException();
		}
	}

	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		// convert password to array
		char[] list = password.toCharArray();
		// set return value
		boolean status = false;
		// loop through password to see if there is at least one uppercase character
		for (int i = 0; i < list.length; i++) {
			if (Character.isUpperCase(list[i])) {
				status = true;
			}
		}
		// return actual value
		if (status == true) {
			return status;
		}
		else {
			throw new NoUpperAlphaException();
		}
	}

	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		// convert password to array
		char[] list = password.toCharArray();
		// set return value
		boolean status = false;
		// loop through password to see if there is at least one lowercase character
		for (int i = 0; i < list.length; i++) {
			if (Character.isLowerCase(list[i])) {
				status = true;
			}
		}
		// return actual value
		if (status == true) {
			return status;
		}
		else {
			throw new NoLowerAlphaException();
		}
	}
	
	public static boolean hasDigit(String password) throws NoDigitException{
		// convert password to array
		char[] list = password.toCharArray();
		// set return value
		boolean status = false;
		// loop through password to see if there is at least one digit character
		for (int i = 0; i < list.length; i++) {
			if (Character.isDigit(list[i])) {
				status = true;
			}
		}
		// return actual value
		if (status == true) {
			return status;
		}
		else {
			throw new NoDigitException();
		}
	}

	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		// convert password to array
		char[] list = password.toCharArray();
		char[] listSpecial = {'!','@','#','$','%','^','&','*','-','_'};
		// set return value
		boolean status = false;
		// loop through password to see if there is at least one special character
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < listSpecial.length; j++) {
				if ((list[i]) == (listSpecial[j])) {
					status = true;
				}
			}
		}
		// return actual value
		if (status == true) {
			return status;
		}
		else {
			throw new NoSpecialCharacterException();
		}
	}

	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException{
		// convert password to array
		String[] list = password.split("");
		// set return value
		boolean status = false;

		// search password for any repeating characters
		for (int i = 0; i < list.length - 2; i++) {
			if (list[i].equals(list[i+1]) && list[i].equals(list[i+2])) {
				throw new InvalidSequenceException();
			}
		}
		
		// final return statement
		return true;
	}

	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		return false;
	}
	
}
