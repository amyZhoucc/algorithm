class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length < 2) return res;

        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] > target) return res;
            int temp = nums[left] + nums[right];
            if(temp == target){
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }
            else if(temp < target) left++;
            else right--;
        }
        return res;
    }
}