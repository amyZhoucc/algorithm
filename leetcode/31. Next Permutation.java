class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 1) return;

        for(int i = len - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
               Arrays.sort(nums, i, len);
               for(int j = i; j < len; j++){
                if(nums[i - 1] < nums[j]){
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[j];
                    nums[j] = temp;
                    return;
                }
               }
            }
        }
        Arrays.sort(nums);
        return;
    }
}