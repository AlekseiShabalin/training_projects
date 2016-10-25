package ru.ashabalin;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksei Shabalin on 25.10.2016.
 */
public class PalindromeTest {

	Palindrome palindrome = new Palindrome();

	@Test
	public void whenEnterRightWord() throws Exception {
		String testString = "РоТоР";
		System.setIn(new ByteArrayInputStream(testString.getBytes()));
		boolean resultTest = palindrome.chekerWord();
		assertTrue(resultTest);
	}

	@Test
	public void whenEnterWrongWord() throws Exception {
		String testString = "Hello";
		System.setIn(new ByteArrayInputStream(testString.getBytes()));
		boolean resultTest = palindrome.chekerWord();
		assertFalse(resultTest);
	}

	@Test (expected = IOException.class)
	public void whenEnterWordLongerFiveLetters() throws Exception {
		String testString = "ПриВет";
		System.setIn(new ByteArrayInputStream(testString.getBytes()));
		boolean resultTest = palindrome.chekerWord();
		assertFalse(resultTest);
	}

}