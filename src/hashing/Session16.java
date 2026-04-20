package hashing;

import java.util.HashMap;
import java.util.Map;

public class Session16 {
    public static void main(String... args) {

    }

    // https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
    public long subarrayXor(int[] arr, int k) {
        long count = 0L;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentXor = 0;

        for (int i = 0; i < n; i++) {
            currentXor ^= arr[i];
            int target = k ^ currentXor;

            if (map.containsKey(target)) {
                count = count + map.get(target);
            }
            map.put(currentXor, map.getOrDefault(currentXor, 0) + 1);
        }
        return count;

    }
    // https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
    public int cntSubarrays(int[] arr, int k) {
        int currentSum = 0, n = arr.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}