package ru.ashabalin.lesson5;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

/**
 * Created by Aleksei Shabalin on 25.06.2016.
 */
public class RotateMassiveTest {
    @Test
    public void rotateLeft() throws Exception {
        int mas[][] = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };
        RotateMassive rotateMassive = new RotateMassive(mas);
        rotateMassive.rotateLeft();
        int resultMas[][] = rotateMassive.getMassive();
        int controlMas[][] = {
                {6, 12, 18, 24, 30, 36},
                {5, 11, 17, 23, 29, 35},
                {4, 10, 16, 22, 28, 34},
                {3, 9, 15, 21, 27, 33},
                {2, 8, 14, 20, 26, 32},
                {1, 7, 13, 19, 25, 31},
        };
        Assert.assertThat(resultMas, is(controlMas));
    }

    @Test
    public void rotateRight() throws Exception {
        int mas[][] = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };
        RotateMassive rotateMassive = new RotateMassive(mas);
        rotateMassive.rotateRight();
        int resultMas[][] = rotateMassive.getMassive();
        int controlMas[][] = {
                {31, 25, 19, 13, 7, 1},
                {32, 26, 20, 14, 8, 2},
                {33, 27, 21, 15, 9, 3},
                {34, 28, 22, 16, 10, 4},
                {35, 29, 23, 17, 11, 5},
                {36, 30, 24, 18, 12, 6},
        };
        Assert.assertThat(resultMas, is(controlMas));
    }

}