package ru.ashabalin;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Aleksei Shabalin on 22.10.2016.
 */

public class MinimumNumberTest{

	@Test
	public void minimumNumberTest() throws Exception {

		MinimumNumber minimumNumberTest = new MinimumNumber();
		String testString = "-10.25 15 24";
		System.setIn(new ByteArrayInputStream(testString.getBytes()));
		double resultTest = minimumNumberTest.minimumNumber();
		assertEquals(-10.25d, resultTest, 0.000000000001);

	}

}