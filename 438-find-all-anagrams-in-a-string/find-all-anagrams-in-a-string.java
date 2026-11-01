import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return result;
        }

        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']--;

            if (right - left + 1 > m) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == m) {

                boolean match = true;
                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}
