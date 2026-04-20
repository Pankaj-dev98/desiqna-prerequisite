package hashing;

import java.util.HashMap;
import java.util.Map;

public class Session15 {
    public static void main(String... args) {

    }

    // https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int e = nums[i];

            if (map.containsKey(-k + e)) {
                count += map.get(-k + e);
            }

            if (map.containsKey(k + e)) {
                count += map.get(k + e);
            }

            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        return count;
    }
}