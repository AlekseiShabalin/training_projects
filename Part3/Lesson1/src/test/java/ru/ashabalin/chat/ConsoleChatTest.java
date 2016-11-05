package ru.ashabalin.chat;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;


/**
 * @author Aleksei Shabalin on 04.11.2016.
 */
public class ConsoleChatTest {
	@Test
	public void runChatTest() throws Exception {
		String userPhrase = "Hello\nзакончить";
		ByteArrayInputStream inTest = new ByteArrayInputStream(userPhrase.getBytes());
		ByteArrayOutputStream outTest = new ByteArrayOutputStream();

		new ConsoleChat(inTest, outTest).runChat();
		assertEquals(String.format("%s\n%s\n%s","User: Hello", "Bot: Hello", "User: закончить"),
									outTest.toString().trim());
	}

	@Test
	public void runChatWhenStopThenContinue() throws Exception {
		String userPhrase = "Hello\nстоп\nWhat are you doing?\nпродолжить\nзакончить";
		ByteArrayInputStream inTest = new ByteArrayInputStream(userPhrase.getBytes());
		ByteArrayOutputStream outTest = new ByteArrayOutputStream();

		new ConsoleChat(inTest, outTest).runChat();
		assertEquals(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s","User: Hello", "Bot: Hello", "User: стоп",
					"User: What are you doing?", "User: продолжить", "Bot: Hello","User: закончить"),outTest.toString().trim());
	}

	@Test
	public void runChatWhenStopThenFinish() throws Exception {
		String userPhrase = "Hello\nстоп\nзакончить";
		ByteArrayInputStream inTest = new ByteArrayInputStream(userPhrase.getBytes());
		ByteArrayOutputStream outTest = new ByteArrayOutputStream();

		new ConsoleChat(inTest, outTest).runChat();
		assertEquals(String.format("%s\n%s\n%s\n%s","User: Hello", "Bot: Hello", "User: стоп",
						"User: закончить"),outTest.toString().trim());
	}
}