class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canSplit(int[] nums, int k, int limit) {
        int subarrays = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > limit) {
                subarrays++;
                sum = 0;
            }

            sum += num;
        }
        return subarrays <= k;
    }
}