package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session6 {
    public static void main(String... args) {
        Session6 driver = new Session6();
        driver.countSubarrays(new int[]{1, 1, 1}, 2);
        driver.countSubarrays(new int[]{1, 2, 3}, 3);
        driver.countSubarrays(new int[]{1, -1, 0}, 0);
        driver.countSubarrays(new int[]{-1, -1, 1}, 0);
        driver.countSubarrays(new int[]{10, 2, -2, -20, 10}, -10);
        driver.countSubarrays(new int[]{1}, 0);
        driver.countSubarrays(new int[]{0, 0, 0, 0}, 0);
    }

    private void countSubarrays(int[] nums, int k) {
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);

        for (int e : nums) {
            currentSum += e;
            count += map.getOrDefault(currentSum - k, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        System.out.println("k = " + k);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("count = " + count);
        System.out.println("----");
    }
}