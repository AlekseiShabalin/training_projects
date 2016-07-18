package ru.ashabalin.lesson6;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

/**
 * Created by Aleksei Shabalin on 02.07.2016.
 */
public class SubTest {
    /*
    * тест определяющий содержится подстрока в сроке
    * subString - подстрока проверяемкая на вхождение в строку
    * originString - строка
    * resultTest - переменная ожидаемого результата
    */
    @Test
    public void rightContains() throws Exception{
        String subString = "cde";
        String originString = "abcdfgcde";
        boolean resultTest = true;

        Sub subTest = new Sub();
        boolean result = subTest.contains(originString, subString);
        Assert.assertThat(resultTest, is(result));
    }

    /*
    * тест определяющий отсутствие подстрокиа в сроке
    * subString - подстрока проверяемкая на вхождение в строку
    * originString - строка
    * resultTest - переменная ожидаемого результата
    */
    @Test
    public void wrongContains() throws Exception{
        String subString = "ced";
        String originString = "abcdfgcde";
        boolean resultTest = false;

        Sub subTest = new Sub();
        boolean result = subTest.contains(originString, subString);
        Assert.assertThat(resultTest, is(result));
    }
}