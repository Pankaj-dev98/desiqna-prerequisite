package two_pointers;

import java.util.Arrays;

public class MasterClass {
    public static void main(String... args) {
        int[] nums = { 1,2,1,3,5,2,4 };
        int k = 4;

        MasterClass driver = new MasterClass();
        driver.subarraysSumLessEqualToK(nums, k);
    }

    private void subarraysSumLessEqualToK(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        int currentSum = 0;
        long count = 0L;

        while (j < n) {
            currentSum += nums[j];

            while (currentSum > k) {
                currentSum -= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("count = " + count);
    }
}