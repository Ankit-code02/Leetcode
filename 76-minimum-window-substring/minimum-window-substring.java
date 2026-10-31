
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch] > 0) {
                required--;
            }

            freq[ch]--;
            while (required == 0) {

                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);

                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}
