package util;

import java.util.Random;

public class RandomIntegerGenerator {

    public static int[] asArray(int size, int start, int end) {
        int[] array = new int[size];
        end++;
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(start, end);
        }
        return array;
    }

    public static int asInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static int asInt(int start, int end) {
        return new Random().nextInt(start, ++end);
    }

}
