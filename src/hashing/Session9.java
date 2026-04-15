package hashing;

// https://leetcode.com/problems/valid-anagram/description/
public class Session9 {
    public static void main(String... args) {
        Session9 driver = new Session9();
        System.out.println(driver.isAnagram("abc", "cab") + "\n----");

        System.out.println(driver.isAnagram("abcd", "a") + "\n----");
        System.out.println(driver.isAnagram("aaa", "aab") + "\n----");
    }

    public boolean isAnagram(String s, String t) {
        System.out.println("s = " + s);
        System.out.println("t = " + t);

        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }
}