package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session3 {
    public static void main(String... args) {
        Session3 driver = new Session3();

        driver.countPairs(new int[]{1, 5, 3, 4, 2}, 2);
        driver.countPairs(new int[]{1, 1, 1}, 0);
        driver.countPairs(new int[]{8, 12, 16, 4}, 4);
        driver.countPairs(new int[]{1, 2, 3}, 10);
        driver.countPairs(new int[]{-2, 0, 2}, 2);
    }

    private void countPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int e : nums) {
            count += map.getOrDefault(k + e, 0);
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        System.out.println("k = " + k);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("count = " + count);
        System.out.println("----");
    }
}