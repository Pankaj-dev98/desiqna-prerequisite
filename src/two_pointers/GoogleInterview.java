package two_pointers;

import java.util.Arrays;

public class GoogleInterview {
    public static void main(String... args) {
        int[] a = { -4,-1,-1,0,2,2,4,7,7,11,14 };
        int k1 = 3;
        int k2 = 3;

        GoogleInterview driver = new GoogleInterview();
        driver.solution01(a, k1, k2);
    }

    // https://docs.google.com/document/d/1HJ-uQ5VpiTRoW50S0L6sootpiOR_gJ1k6vHUxAiVgR0/edit?tab=t.0
    private int[] suffix;
    public void solution01(int[] a, int k1, int k2) {
        int n = a.length;
        int i = 0, j = n - 3;
        long totalCount = 0L;
        validPairs(a, k2);

        while (i < j) {
            int l = i, r = j - 1;

            while (l <= r) {
                int mid = (l + r) >> 1;

                if (a[mid] + a[j] > k1) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            long pairs = j - l;
            long rightPairs = suffix[j + 1];
            totalCount += (pairs * rightPairs);

            //
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            System.out.println("rightPairs = " + rightPairs);
            System.out.println("totalCount = " + totalCount);
            System.out.println("----");
            //
            i = l;
            j--;
        }

        System.out.println("k1 = " + k1);
        System.out.println("k2 = " + k2);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("totalCount = " + totalCount);
    }

    private void validPairs(int[] a, int k) {
        int n = a.length;
        suffix = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int l = i + 1, r = n - 1;

            while (l <= r) {
                int mid = (l + r) >> 1;

                if (a[i] + a[mid] > k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (l == n) {
                break;
            }
            suffix[i] = n - l;
        }

        System.out.println("suffix = " + Arrays.toString(suffix));
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i] + suffix[i + 1];
        }
        System.out.println("suffix = " + Arrays.toString(suffix));
    }
}