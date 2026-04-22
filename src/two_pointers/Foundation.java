package two_pointers;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Foundation {
    public static void main(String... args) {
        int[] nums = {1, 2, 3, 4, 0, 1, 2, 1};
        int k = 4;

        Foundation driver = new Foundation();
        driver.solution1(nums, k);
    }

    // Given an array of all integers >= 0 => Find the largest subarray whose sum is <= k.
    public void solution1(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        int currentSum = 0;
        int max = 0;


        while (j < n) {
            currentSum += nums[j];
            while (currentSum > k) {
                currentSum -= nums[i];
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println("max = " + max);
    }

    // Find the largest valid substring - Valid string is a string where any pair of characters have diff <= k
    public void soultion2(String str, int k) {
        int i = 0, j = 1;
        int n = str.length();
        int diff = 0, maxLen = 0;

        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.put((int) str.charAt(0), 1);

        while (j < n) {
            sortedMap.put((int) str.charAt(j), sortedMap.getOrDefault((int) str.charAt(j), 0) + 1);
            diff = sortedMap.lastKey() - sortedMap.firstKey();

            while (diff > k) {
                int remove = (int) str.charAt(i);
                sortedMap.put(remove, sortedMap.get(remove) - 1);
                if (sortedMap.get(remove).equals(0)) {
                    sortedMap.remove(remove);
                }
                diff = sortedMap.lastKey() - sortedMap.firstKey();
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        System.out.println("maxLen = " + maxLen);
    }
}