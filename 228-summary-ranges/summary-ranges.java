import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int start = 0;

        for (int i = 0; i < nums.length; i++) {

            // End of current range
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {

                if (start == i) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i]);
                }

                start = i + 1;
            }
        }

        return result;
    }
}