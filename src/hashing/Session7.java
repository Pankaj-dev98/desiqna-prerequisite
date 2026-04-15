package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session7 {
    public static void main(String... args) {
        Session7 driver = new Session7();
        driver.largestSubarraySumK(new int[] { 3,1,3,-2,2 }, 4);
    }

    private void largestSubarraySumK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        int maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currentSum - k));
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("maxLen = " + maxLen);
        System.out.println("----");
    }

    private void smallestSubarraySumK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - k)) {
                minLen = Math.min(minLen, i - map.get(currentSum - k));
            }

            map.put(currentSum, i);
        }
    }
}