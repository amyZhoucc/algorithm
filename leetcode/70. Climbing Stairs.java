class Solution {                // 动态规划题
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;  // 处理特殊情况
        int prev = 1;       // 存放前一个的爬楼梯结果
        int cur = 1;        // 存放当前爬楼梯结果
        for(int i = 2; i <= n; i++){    // 遍历到当前楼梯数，算出一共有几种方法
            int temp = prev;
            prev = cur;
            cur = temp + prev;
        }
        return cur;
    }
}