package hashing;

import java.util.HashMap;
import java.util.Map;

public class Session20 {
    public static void main(String... args) {
//        int[] capacity = {2, 9, 3, 3, 3, 9, 2};

        int[] capacity = { 9,2,3,4,9,5,8,9,9 };
        Session20 driver = new Session20();
        System.out.println(
//            driver.countStableSubarrays(capacity)
        );
        System.out.println("----");

        System.out.println(
            driver.countStableSubarrays(new int[] {-4,4,0,0,-8,-4})
        );
    }

    // https://leetcode.com/problems/stable-subarrays-with-equal-boundary-and-interior-sum/description/
    public long countStableSubarrays(int[] capacity) {
        Map<Pair, Integer> map = new HashMap<>();
        int n = capacity.length;
        long count = 0L;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            int num = capacity[i];
            currentSum += num;
            long newSum = currentSum - (2L * num);

            //
            System.out.println("i = " + i);
            System.out.println("num = " + num);
            System.out.println("currentSum = " + currentSum);
            System.out.println("newSum = " + newSum);
            System.out.println("map = " + map);
            System.out.println("----");

            //
            count += map.getOrDefault(new Pair(newSum, num), 0);

            if (i > 0 && num == 0 && capacity[i - 1] == 0) {
                count--;
            }

            Pair current = new Pair(currentSum, num);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        return count;
    }

    private record Pair(long sum, int endNum) {

    }
}