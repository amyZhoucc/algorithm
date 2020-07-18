class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;  // 遍历；指示最新数组的最后一个非零值
        for(; first < nums.length; first++){
            if(nums[first] == 0)        // 如果遇到的是0，直接跳过
                continue;
            else{                   // 遇到的不是0，那么移动
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                second++;
                
            }
        }
    }
}