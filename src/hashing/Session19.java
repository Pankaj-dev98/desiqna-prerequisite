package hashing;

import java.util.Arrays;

public class Session19 {
    public static void main(String... args) {
        Session19 driver = new Session19();
        String s = "LCTKLCLT";
        System.out.println(driver.numOfSubsequences(s));

//        s = "LMCT";
//        driver.numOfSubsequences(s);
    }

    // https://leetcode.com/problems/maximum-number-of-subsequences-after-one-inserting/
    private int[] prefix;
    private int[] suffix;
    public long numOfSubsequences(String s) {
        int n = s.length();
        prefix = new int[n];
        suffix = new int[n];

        long max = 0L;
        long original = helper1(s, true);
        long l = helper1("L" + s, false);
        long t = helper1(s + "T", false);
        max = Math.max(l, t);

        System.out.println("s = " + s);
        System.out.println("prefix = " + Arrays.toString(prefix));
        System.out.println("suffix = " + Arrays.toString(suffix));
        System.out.println("l = " + l);
        System.out.println("t = " + t);


        for (int i = 0; i < n - 1; i++) {
            long extra = (long) prefix[i] * suffix[i + 1];
            max = Math.max(max, original + extra);
        }

        return max;
    }

    private long helper1(String s, boolean flag) {
        int n = s.length();
        long l = 0, lc = 0, lct = 0;

        if (flag) {
            prefix[0] = s.charAt(0) == 'L' ? 1 : 0;
            suffix[n - 1] = s.charAt(n - 1) == 'T' ? 1 : 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L') {
                l++;
            } else if (c == 'C') {
                lc += l;
            } else if (c == 'T') {
                lct += lc;
            }

            if (flag) {
                if (i != 0) {
                    prefix[i] = prefix[i - 1] + (c == 'L' ? 1 : 0);
                    suffix[n - i - 1] = suffix[n - i] + (s.charAt(n - i - 1) == 'T' ? 1 : 0);
                }
            }
        }

        return lct;
    }
}