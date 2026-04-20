package hashing;

import java.util.Arrays;

// https://docs.google.com/document/d/1FqaW_z9jDbabEoFFBHrgcV5Ve4YyLOfjCmttwnbHSTM/edit?tab=t.0
public class Session10 {
    public static void main(String... args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4 };
        Session10 driver = new Session10();

//        driver.kadanesAlgo(nums);
        driver.solution(new int[] { -10,-5,2,4,-15,-20,1,2 } );
    }

    private void part01(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        System.out.println("prefix = " + Arrays.toString(prefix));
    }

    // p[i] = Total sum of the maximal subarray ending at index i.
    private void kadanesAlgo(int[] nums) {
        int n = nums.length;
        int currentSum = nums[0];
        int maxSum = nums[0];
        System.out.println("nums = " + Arrays.toString(nums));

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum     = Math.max(maxSum, currentSum);

            System.out.println("i = " + i);
            System.out.println("currentSum = " + currentSum);
            System.out.println("maxSum = " + maxSum);
            System.out.println("----");
        }
    }

    /*
    Given an array find two disjoint subarrays of 2 largest sums (which are not
    intersecting). Return their sum.

    ie. [i --- j]...[k --- l]
        k > j
    */
    private void solution(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int[] maxLeft   = new int[n];
        int[] maxRight  = new int[n];
        prefixMax[0] = nums[0];
        suffixMax[n - 1] = nums[n - 1];
        maxLeft[0] = nums[0];
        maxRight[n - 1] = nums[n - 1];

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1] + nums[i], nums[i]);
            maxLeft[i] = Math.max(maxLeft[i - 1], prefixMax[i]);

            suffixMax[n - i - 1] = Math.max(suffixMax[n - i] + nums[n - i - 1], nums[n - i - 1]);
            maxRight[n - i - 1]  = Math.max(maxRight[n - i], suffixMax[n - i  -1]);
        }

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, maxLeft[i] + maxRight[i + 1]);
        }

        System.out.println("nums      = " + Arrays.toString(nums));
        System.out.println("prefixMax = " + Arrays.toString(prefixMax));
        System.out.println("maxLeft   = " + Arrays.toString(maxLeft));
        System.out.println("suffixMax = " + Arrays.toString(suffixMax));
        System.out.println("maxRight  = " + Arrays.toString(maxRight));
        System.out.println("ans = " + ans);
        System.out.println("----");

    }
}