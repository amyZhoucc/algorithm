class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;      // 排除数组为空的情况

        int first = 0, second = 0;  // 设置双指针，first用来遍历，second用来指示最新结果
        for(; first < nums.length; first++){
            if(nums[second] != nums[first]){ // 如果不相等，就second就可以向后移一位，并且更新数组
                second++;
                nums[second] = nums[first];
            }
        }
        second++;       // second需要指示个数，所以+1
        return second;
    }
}