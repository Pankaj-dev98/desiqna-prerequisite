package hashing;

import java.util.Arrays;

public class Session5 {
    public static void main(String... args) {
        Session5 driver = new Session5();

        driver.calcSum(new int[]{1, 2, 3, 4, 5}, 0, 2);
        driver.calcSum(new int[]{1, 2, 3, 4, 5}, 1, 3);
        driver.calcSum(new int[]{10, 20, 30, 40}, 2, 3);
        driver.calcSum(new int[]{5, 5, 5, 5}, 0, 3);
    }

    private void calcSum(int[] nums, int l, int r) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int sum = prefix[r] - (l == 0 ? 0 : prefix[l - 1]);

        System.out.println("l = " + l);
        System.out.println("r = " + r);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("prefix = " + Arrays.toString(prefix));
        System.out.println("sum = " + sum);
        System.out.println("----");
    }
}