package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Session12 {
    public static void main(String... args) {
        Session12 driver = new Session12();
        driver.doc01(new int[] {0, 5, 5, 5, 4}, 5);

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        driver.doc02(nums, target);

        String input = """
            3
            1 4 1
            3
            1 1
            1 2
            0 2""";
        driver.doc03(input);
    }

    // https://www.geeksforgeeks.org/dsa/find-frequency-number-array/
    private void doc01(int[] a, int x) {
        int freq = 0;
        for (int e : a) {
            if (e == x) {
                freq++;
            }
        }
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("x = " + x);
        System.out.println("freq = " + freq);
        System.out.println("----");
    }

    // https://leetcode.com/problems/two-sum/description/
    private void doc02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("target = " + target);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(i + ", " + map.get(target - nums[i]) + "\n----");
                return;
            }
            map.put(nums[i], i);
        }

        System.out.println("----");
    }

    // https://www.spoj.com/problems/CSUMQ/
    private void doc03(String input) {
        String[] lines = input.split("\n");
        int line = 0;
        int n = Integer.parseInt(lines[line++]);
        int[] nums   = new int[n];
        int[] prefix = new int[n];

        String[] arr = lines[line++].split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        System.out.println("nums   = " + Arrays.toString(nums));
        System.out.println("prefix = " + Arrays.toString(prefix));

        int q = Integer.parseInt(lines[line++]);
        for (int i = 0; i < q; i++) {
            arr = lines[line++].split(" ");
            int l = Integer.parseInt(arr[0]);
            int r = Integer.parseInt(arr[1]);

            int rangeSum = prefix[r] - (l == 0 ? 0 : prefix[l - 1]);
            System.out.println("l = " + l);
            System.out.println("r = " + r);
            System.out.println("rangeSum = " + rangeSum);
        }
    }
}