package hashing;

import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class Session11 {
    public static void main(String... args) {
        int[] nums = {5,5,3,3,3,2,2,2,1,1};
        Session11 driver = new Session11();

        driver.solution(nums);
    }

    /*
    Alex has n piles of boxes with varying heights.
    In each step, Alex can remove any number of boxes from the tallest pile to reduce its height to match the next tallest pile.
    Determine the minimum number of steps required to make all piles equal in height.
    */
    private void solution(int[] piles) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>((a, b) -> b - a);
        int ans = 0;

        for (int e : piles) {
            sortedMap.put(e, sortedMap.getOrDefault(e, 0 ) + 1);
        }

        System.out.println("sortedMap = " + sortedMap);

        while (sortedMap.size() > 1) {
            int steps = sortedMap.pollFirstEntry().getValue();
            ans += steps;

            var entry = sortedMap.pollFirstEntry();
            int k = entry.getKey();
            int v = entry.getValue();

            sortedMap.put(k, v + steps);
        }

        System.out.println("ans = " + ans);
    }

}