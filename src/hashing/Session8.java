package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session8 {
    public static void main(String... args) {
        Session8 driver = new Session8();

        driver.countLargestSubarraysSumK(new int[] { 3,2,3,3,2,8 }, 8);
        driver.countLargestSubarraysSumK(new int[] {1,0,0,1}, 1 );
        driver.countLargestSubarraysSumK(new int[] {1, 0, 1}, 1);
        driver.countLargestSubarraysSumK(new int[] {2, -2, 2, -2, 2}, 2);

    }

    private void countLargestSubarraysSumK(int[] nums, int k) {
        int count = 0, maxLen = -1;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);


        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - k)) {
                int length = i - map.get(currentSum - k);
                if (length == maxLen) {
                    count++;
                } else if (length > maxLen) {
                    maxLen = length;
                    count = 1;
                }
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("maxLen = " + maxLen);
        System.out.println("count = " + count);
        System.out.println("----");
    }
}