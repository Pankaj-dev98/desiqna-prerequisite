package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session13 {
    public static void main(String... args) {
        Session13 driver = new Session13();
        int[] nums = { 1,2,3,3,3,2,1,2,2,1,8 };
        String[] words = {"bella", "label", "roller"};

        driver.doc01(nums);
        driver.doc02("loveleetcode");
        driver.doc03(words);
    }

    // https://leetcode.com/problems/find-common-characters/description/
    private void doc03(String[] words) {
        List<String> commons = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int min = Integer.MAX_VALUE;

            for (String s : words) {
                int freq = 0;
                for (char ch : s.toCharArray()) {
                    if (ch == c) {
                        freq++;
                    }
                }
                min = Math.min(min, freq);
            }
            for (int i = 0; i < (min == Integer.MAX_VALUE ? 0 : min); i++) {
                commons.add(String.valueOf(c));
            }
        }
        System.out.println("commons = " + commons);
    }

    // https://www.geeksforgeeks.org/dsa/maximum-distance-two-occurrences-element-array/
    private void doc01(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            int k1 = nums[i];
            int k2 = nums[j];

            if (!map.containsKey(k1)) {
                map.put(k1, new int[] { -1, -1 } );
            }
            if (!map.containsKey(k2)) {
                map.put(k2, new int[] { -1, -1 });
            }

            int[] arr = map.get(k1);
            if (arr[0] == -1) {
                arr[0] = i;
            }
            arr = map.get(k2);
            if (arr[1] == -1) {
                arr[1] = j;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int[] a : map.values()) {
            max = Math.max(max, a[1] - a[0]);
        }

        map.entrySet().forEach(e -> System.out.println(e.getKey() + " - > " + Arrays.toString(e.getValue())));
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("max = " + max + "\n----");
    }

    // https://leetcode.com/problems/first-unique-character-in-a-string/description/
    private void doc02(String s) {
        System.out.println("s = " + s);
        int[] freq = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        System.out.println("freq = " + Arrays.toString(freq));
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] != 1) {
                continue;
            }
            System.out.println(i + "\n----");
            return;
        }
        System.out.println(-1);
        System.out.println("----");
    }
}