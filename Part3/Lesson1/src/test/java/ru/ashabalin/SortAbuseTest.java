package ru.ashabalin;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 13.10.2016.
 */

public class SortAbuseTest{

	@Test
	public void dropAbusesTest() throws Exception {
		ByteArrayOutputStream outputTest = new ByteArrayOutputStream();

		String testString = "One First Two Second Three Third";
		ByteArrayInputStream inputTest = new ByteArrayInputStream(testString.getBytes());
		String[] abuse = {"first", "second", "Third"};

		new SortAbuse().dropAbuses(inputTest, outputTest, abuse);
		assertEquals(outputTest.toString(),("One  Two  Three "));
	}

}
