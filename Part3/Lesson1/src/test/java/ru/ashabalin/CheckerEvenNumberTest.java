package ru.ashabalin;

import org.junit.Test;
import org.mockito.Mockito;
import java.io.*;

import static org.junit.Assert.*;

/**
 * @author Aleksei Shabalin on 09.10.2016.
 */
public class CheckerEvenNumberTest extends Mockito {

	@Test
	public void whenEvenNumber() throws Exception {

		InputStream testReader = mock(InputStream.class);
		when(testReader.read()).thenReturn(2);

		CheckerEvenNumber checkerEvenNumber = new CheckerEvenNumber();

		assertTrue(checkerEvenNumber.isNumber(testReader));
	}

	@Test
	public void whenOddNumber() throws Exception {

		InputStream testReader = mock(InputStream.class);
		when(testReader.read()).thenReturn(1);

		CheckerEvenNumber checkerEvenNumber = new CheckerEvenNumber();

		assertFalse(checkerEvenNumber.isNumber(testReader));
	}



}