class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;      // 处理特殊情况——不存在要偷的房子

        int len = nums.length;
        int[] value = new int[len + 1];         // 存放动态规划子问题的解
        value[0] = 0;           // 处理边界条件——不存在房子时
        value[1] = nums[0];     // 只存在一个房子时
        for(int i = 1; i < len; i++){
            value[i + 1] = Math.max(value[i - 1] + nums[i], value[i]);  // 两种选择：偷当前房子+前前子问题的解；不偷当前房子+前子问题的解
        }
    return value[len];          // 返回最后一个子问题——原问题的解
    }
}

class Solution {                            // 优化后的解法——空间复杂度从O(n) -> O(1)
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;      // 处理特殊情况——不存在要偷的房子

        int len = nums.length;
        int first = 0;                  // 分别存放前前个的最优解
        int second = nums[0];           // 存放前个的最优解
        for(int i = 1; i < len; i++){
            int temp = first;
            first = second;
            second = Math.max(temp + nums[i], second);
        }
    return second;
    }
}