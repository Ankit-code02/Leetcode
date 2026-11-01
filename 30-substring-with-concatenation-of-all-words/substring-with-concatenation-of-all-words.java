import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;

        if (s.length() < windowSize) {
            return result;
        }
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(
                word,
                wordCount.getOrDefault(word, 0) + 1
            );
        }
        for (int i = 0; i < wordLength; i++) {

            int left = i;
            int count = 0;

            Map<String, Integer> windowCount = new HashMap<>();

            for (int right = i;
                 right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (!wordCount.containsKey(word)) {
                    windowCount.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }

                windowCount.put(
                    word,
                    windowCount.getOrDefault(word, 0) + 1
                );

                count++;
                while (windowCount.get(word) > wordCount.get(word)) {

                    String leftWord = s.substring(
                        left, left + wordLength
                    );

                    windowCount.put(
                        leftWord,
                        windowCount.get(leftWord) - 1
                    );

                    left += wordLength;
                    count--;
                }
                if (count == totalWords) {

                    result.add(left);
                    String leftWord = s.substring(
                        left, left + wordLength
                    );

                    windowCount.put(
                        leftWord,
                        windowCount.get(leftWord) - 1
                    );

                    left += wordLength;
                    count--;
                }
            }
        }

        Collections.sort(result);

        return result;
    }
}
