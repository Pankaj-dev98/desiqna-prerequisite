package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session0 {
    public static void main(String... args) {
        Session0 driver = new Session0();

        int[] nums = {
            7, 7, 7, 7,
            42, 42, 42, 42,
            100, 100, 100, 100,
            0, 15, 25, 30, 50, 60, 80, 90
        };

        driver.maxMinFrequency(nums);
    }

    private void maxMinFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : nums) {
            map.put(
                e, map.getOrDefault(e, 0) + 1
            );
        }

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        int minElement = -1, maxElement = -1;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int element = e.getKey();
            int frequency = e.getValue();

            if (minFreq > frequency) {
                minFreq = frequency;
                minElement = element;
            }

            if (maxFreq < frequency) {
                maxFreq = frequency;
                maxElement = element;
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("minElement = " + minElement);
        System.out.println("minFreq = " + minFreq);
        System.out.println("maxElement = " + maxElement);
        System.out.println("maxFreq = " + maxFreq);
        System.out.println("----");
    }
}