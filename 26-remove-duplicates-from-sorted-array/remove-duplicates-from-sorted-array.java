class Solution {
    public int removeDuplicates(int[] nums) {
        int low = 0;
        int k = 1;
        int high = 1;
        while(high < nums.length){
            if(nums[low]==nums[high]){
                high++;
                continue;
            }
            else if(nums[low]!=nums[high]){
                nums[low+1]=nums[high];
                low++;
                high++;
                k++;
            }
            
        }
        return k;
    }
}