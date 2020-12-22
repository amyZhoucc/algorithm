class Solution {            // 动态规划题
    public int minCostClimbingStairs(int[] cost) {
        int[] store = new int[cost.length];
        store[0] = cost[0];
        store[1] = cost[1];
        for(int i= 2; i < cost.length; i++){
            store[i] = Math.min((store[i - 2] + cost[i]), (store[i - 1] + cost[i]));
        }
        return Math.min(store[cost.length - 2], store[cost.length - 1]);
    }
}

class Solution {            // 空间优化
    public int minCostClimbingStairs(int[] cost) {
        int prepre = cost[0];
        int pre = cost[1];
        for(int i= 2; i < cost.length; i++){
            int cur = Math.min(prepre, pre) + cost[i];
            prepre = pre;
            pre = cur;
        }
        return Math.min(pre, prepre);
    }
}