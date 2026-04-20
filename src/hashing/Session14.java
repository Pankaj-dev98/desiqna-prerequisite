package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Session14 {
    public static void main(String... args) {

    }

    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int e : nums) {
            set.add(e);
        }

        int maxLen = 0;
        for (int e : set) {
            if (set.contains(e - 1)) {
                continue;
            }
            int current = e, count = 1;

            while (set.contains(current + 1)) {
                current++;
                count++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }

    // https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
    private int maxLength(int[] arr) {
        int n = arr.length;
        int currentSum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (map.containsKey(currentSum)) {
                maxLen = Math.max(maxLen, i - map.get(currentSum));
            } else {
                map.put(currentSum, i);
            }
        }
        return maxLen;
    }
}