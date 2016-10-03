package ru.ashabalin;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Aleksei Shabalin on 03.10.2016.
 */
public class ExtraTaskTest {
	@Test
	public void mergereArray() throws Exception {
		int testArray1[] = {1, 5};
		int testArray2[] = {2, 3};

		int expect[] = {1, 2, 3, 5};

		ExtraTask testTask = new ExtraTask();
		testTask.mergerArray(testArray1, testArray2);

		assertThat(expect, is(testTask.getArray()));
	}

}