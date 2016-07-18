package ru.ashabalin.lesson5;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Aleksei on 25.06.2016.
 */
public class DelDuplicateTest {
    @Test
    public void removeDuplicate() throws Exception {
            String[] mas = {"a", "b", "a", "c", "d", "f", "a", "g", "h", "j"};

            DelDuplicate delDuplicate = new DelDuplicate(mas);
            delDuplicate.removeDuplicate();
            String resultMas[] = delDuplicate.getDelDuplicate();
            String controlMas[] = {"a", "b", "c", "d", "f", "g", "h", "j", null, null};
            assertThat(controlMas, is(resultMas));
    }
}