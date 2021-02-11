import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PasswordCheckerUtility extends java.lang.Object {
	/**
	 * No arg constructor
	 */
	public PasswordCheckerUtility() {

	}
	
	/**
	 * Makes sure password passes all criteria 
	 * @param passwordString the password
	 * @return a valid password string
	 * @throws LengthException throw if password not long enough
	 * @throws NoDigitException throw if no digit
	 * @throws NoUpperAlphaException throw if no upper case
	 * @throws NoLowerAlphaException throw in no lower case
	 * @throws InvalidSequenceException throw if not valid sequence
	 * @throws NoSpecialCharacterException throw if no special character
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
	NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException 
	{
		//if the variables become false then throw the exception
		//originally I made them true but and then in the for loop the 
		// exception + the variable would be false but that kept repeating the 
		// NoDigitException 
		boolean digit = false;
		boolean upperAlphabet = false;
		boolean lowerAlphabet = false;
		boolean validSequence = true;
		boolean hasSpecialCharacter = false;
		//Goes through each character 
		//if the thing (aka upper case number etc) is there make the variable true and go to the next character
		for(int i = 0; i < passwordString.length() -1; i++)
		{
			if(Character.isDigit(passwordString.charAt(i)))
			{
				digit = true;
			}
		}
		for(int i = 0; i < passwordString.length() - 1; i++)
		{
			if(Character.isUpperCase(passwordString.charAt(i)))
			{
				upperAlphabet = true;
			}
			if(Character.isLowerCase(passwordString.charAt(i)))
			{
				lowerAlphabet = true;
			}
		}
		//I don't know why its giving me an index error....
		//Nevermind I am dumb it's cause it's starts at index of 0 
		for(int i = 0; i < passwordString.length() - 2; i++)
		{
			//The character at any giving point in the string cannot be repeat twice
			// Example Suppp1@
			// first p = 2
			// second p = i + 1 which = 3
			// third p = i + 2 which = 4
			// this would fail it bc it cant be repeated more than 2 times
			if(passwordString.charAt(i) == passwordString.charAt(i + 1) && passwordString.charAt(i) == passwordString.charAt(i  + 2))
			{
				validSequence = false;
			}
		}
		if(specialCharacter(passwordString) == true)
			{
				hasSpecialCharacter = true;
			}
		//Checks every condition/every requirement for a strong password
		
		//If false then throw the exception
		if (passwordString.length() < 6) 
		{
			throw new LengthException();
		}
		if(digit == false)
		{
			throw new NoDigitException();
		}
		if(upperAlphabet == false)
		{
			throw new NoUpperAlphaException();
		}
		if(lowerAlphabet == false)
		{
			throw new NoLowerAlphaException();
		}
		if(hasSpecialCharacter == false)
		{
			throw new NoSpecialCharacterException();
		}
		if(validSequence == false)
		{
			throw new InvalidSequenceException();
		}
		return true;
	}
	 /**
	  *  Sees if password is weak
	  * @param passwordString input string checking if password is weak
	  * @return if password is weak or not
	  */
	public static boolean isWeakPassword(String passwordString) 
	{

		if ((passwordString.length() >= 6) && (passwordString.length() <= 9)) 
		{
			return true;
		} 
		else
			return false;
	}
	
	/**
	 * Checks if theres a special character
	 * @param passwordString input string
	 * @return if there a special character
	 */
	//Made into it's own function to see if string has a Special Character
	public static boolean specialCharacter(String passwordString)
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		return (!matcher.matches());
	}
	/**
	 * Returns all invalid passwords
	 * @param passwords all invalid passwords
	 * @return a list of invalid passwords and the reason why they are invalid
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>(passwords.size());
		//if the password is invalid then add it to the list???
		// try password if wrong catch and add
		for(int i = 0; i < passwords.size(); i++)
		{
			try
			{
				isValidPassword(passwords.get(i));	
			}
			catch (NoDigitException | LengthException | NoUpperAlphaException | NoLowerAlphaException | InvalidSequenceException | NoSpecialCharacterException e)
			{
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
			return invalidPasswords;
}
}