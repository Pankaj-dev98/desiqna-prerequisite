package hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session18 {
    public static void main(String... args) {
        System.out.println(findSecurityLevel(List.of(1,3,2,4), 4));
    }

    public static long findSecurityLevel(List<Integer> pid, int k) {
        int n = pid.size();
        int[] prefix = new int[n];
        prefix[0] = pid.getFirst();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < n; i++) {
            prefix[i] = pid.get(i) + prefix[i - 1];
        }
        // p[j] - p[i - 1] = j - i + 1
        // p[j] -j = p[i - 1] - i + 1

        long count = 0L;
        map.put(1, 1);
        for (int j = 0; j < n; j++) {
            int target = prefix[j] - j;
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            if (j == 0) {
                continue;
            }
            target = prefix[j - 1] - j + 1;
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        return count;
    }
}