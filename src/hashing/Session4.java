package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session4 {
    public static void main(String... args) {
        Session4 driver = new Session4();

        driver.countPairs(new int[]{1, 5, 3, 4, 2}, 2);
        driver.countPairs(new int[]{1, 1, 1}, 0);
        driver.countPairs(new int[]{1, 2, 2, 1}, 1);
        driver.countPairs(new int[]{1, 3, 5}, 10);
        driver.countPairs(new int[]{-1, -3, 1}, 2);
    }

    /*
    calculating the number of pairs (i,j) such that i < j and ∣nums[i]−nums[j]∣=k.
    */
    private void countPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : nums) {
            if (k == 0) {
                count += map.getOrDefault(e, 0);
                continue;
            }
            count += map.getOrDefault(k + e, 0);
            count += map.getOrDefault(-k + e, 0);
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        System.out.println("k = " + k);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("count = " + count);
        System.out.println("----");
    }
}