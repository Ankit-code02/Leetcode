class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;

        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return mergeSort(prefixSum, 0, n + 1, lower, upper);
    }

    private int mergeSort(
        long[] sums,
        int left,
        int right,
        int lower,
        int upper
    ) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(sums, left, mid, lower, upper)
                  + mergeSort(sums, mid, right, lower, upper);
        int low = mid;
        int high = mid;

        for (int i = left; i < mid; i++) {
            while (low < right &&
                   sums[low] - sums[i] < lower) {
                low++;
            }
            while (high < right &&
                   sums[high] - sums[i] <= upper) {
                high++;
            }
            count += high - low;
        }

        long[] merged = new long[right - left];
        int i = left;
        int j = mid;
        int index = 0;

        while (i < mid && j < right) {

            if (sums[i] <= sums[j]) {
                merged[index++] = sums[i++];
            } else {
                merged[index++] = sums[j++];
            }
        }
        while (i < mid) {
            merged[index++] = sums[i++];
        }
        while (j < right) {
            merged[index++] = sums[j++];
        }
        System.arraycopy(merged, 0, sums, left, merged.length);
        return count;
    }
}
