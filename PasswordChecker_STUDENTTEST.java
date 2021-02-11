import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PasswordChecker_STUDENTTEST {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB", "Im2#cool4U", "george2ZZZ", "4sal#", "bertha22#", "4wardMarch#", 
				"august30", "abcdef", "Applesxx#", "aa11b", "pilotProject", "myPassword", 
				"myPassword2", "fLatbread23", "SWAGblAST23$", "c00lduy3" };
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
		
		/* ************* STUDENT  ***************
		   Create another Arraylist of String to
		   use for the testValidPasswordsSTUDENT test
		*/
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("qrzABC12#"));
			PasswordCheckerUtility.isValidPassword("sa23#");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
}
