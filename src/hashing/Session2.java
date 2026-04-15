package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session2 {
    public static void main(String... args) {
        Session2 driver = new Session2();

        driver.countPairs(new int[]{1, 5, 7, -1, 5}, 6);
        driver.countPairs(new int[]{1, 1, 1, 1}, 2);
        driver.countPairs(new int[]{1, 2, 3, 4, 5}, 10);
        driver.countPairs(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11);
        driver.countPairs(new int[]{}, 5);
        driver.countPairs(new int[]{5}, 5);
        driver.countPairs(new int[]{3, 3}, 6);
    }

    /*
    Count all the (i, j) Pairs such that b[i] + b[j] = k (count of such pairs.)
    [i < j]
    */

    private void countPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int e : nums) {
            int req = k - e;
            if (map.containsKey(req)) {
                count += map.get(req);
            }

            map.put(
                e, map.getOrDefault(e, 0) + 1
            );
        }
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("count = " + count);
        System.out.println("----");

    }
}