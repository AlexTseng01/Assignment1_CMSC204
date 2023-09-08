
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	ArrayList<String> passwords2;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"AbC123!@#acb", "abc", "aBc123!@", "aaaBc123!@#", "abc1!@#", "ABCD!@#", "Abc!@#"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
		String[] a = {"abc!@#12346", "Abc!@#aabbcc"};
		passwords2 = new ArrayList<String>();
		passwords2.addAll(Arrays.asList(a));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(1)));
		}
		catch (LengthException E){
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(4)));
		}
		catch (NoUpperAlphaException E){
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides NoUpperAlphaExcepetion",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(5)));
		}
		catch (NoLowerAlphaException E){
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword(passwords.get(2)));
		}
		catch (WeakPasswordException E){
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides WeakPasswordException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(3)));
		}
		catch (InvalidSequenceException E){
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(6)));
		}
		catch (NoDigitException E){
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch (Exception E) {
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
		}
		catch (Exception E) {
			assertTrue("Did not throw Exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		assertEquals(PasswordCheckerUtility.getInvalidPasswords(passwords2).get(0), "abc!@#12346 The password must contain at least one uppercase alphabetic character");
		assertEquals(PasswordCheckerUtility.getInvalidPasswords(passwords2).get(1), "Abc!@#aabbcc The password must contain at least one digit");
	}
	
}
