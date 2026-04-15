package hashing;

import java.util.HashMap;
import java.util.Map;

import static utils.LoggingUtils.print;

public class Session1 {
    public static void main(String... args) {
        Session1 driver = new Session1();

        driver.distanceKOrLess(new int[]{1, 2, 3, 1}, 3);
        driver.distanceKOrLess(new int[]{1, 0, 1, 1}, 1);
        driver.distanceKOrLess(new int[]{1, 2, 3, 1, 2, 3}, 2);
        driver.distanceKOrLess(new int[]{1, 2, 3, 4, 5}, 1);
        driver.distanceKOrLess(new int[]{1, 1}, 1);
        driver.distanceKOrLess(new int[]{1, 2, 1}, 0);
        driver.distanceKOrLess(new int[]{}, 3);
        driver.distanceKOrLess(new int[]{1, 2, 3, 4, 1}, 3);
    }

    /*
    Check if there are any two Equal numbers in an array at a distance less than or equal to k
    */
    private boolean distanceKOrLess(int[] nums, int k) {
        System.out.println("k = " + k);
        if (k == 0) {
            print(nums, true);
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                continue;
            }

            if (i - map.get(nums[i]) <= k) {
                print(nums, "indices: ", i, map.get(nums[i]), true);
                return true;
            } else {
                map.put(nums[i], i);
            }

        }
        print(nums, "No equal elements at a dist <= k");
        return false;
    }
}