class Solution {			// 暴力解法
    public int maxProfit(int[] prices) {
        int maxpro = 0; // 存放最大利润
        for(int i = 0; i < prices.length - 1; i++){        // 买入股票的日子
            for(int j = i + 1; j < prices.length; j++){    // 尝试卖出股票的日子
                int temp =  prices[j] -  prices[i];
                maxpro = maxpro > temp ? maxpro : temp;
            }
        }
        return maxpro;
    }
}

class Solution {		// 一次遍历的方法
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxpro = 0;     // 记录最大利润
        int minprice = prices[0];   // 存放历史最低值
        for(int i = 1; i < prices.length; i++){         // 遍历的描述是：卖出时机——今天卖出的最大价值是多少：就是今天的价格-之前的历史最低价
            minprice = minprice < prices[i-1] ? minprice : prices[i-1]; // 更新历史最低值
            int temp = prices[i] - minprice;
            maxpro = maxpro > temp ? maxpro : temp;
        }
        return maxpro;
    }
}

class Solution {                // 动态规划的方法
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;             // 排除边界条件
        int minprice = prices[0];
        int[]dp = new int[prices.length];           // 维护一个数组，存放当前天时利润的最大值
        dp[0] = 0;

        for(int i = 1; i < prices.length; i++){
            minprice = Math.min(prices[i], minprice);       // 求当前的历史最低值
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);  // 求当前天的
        }
        return dp[prices.length - 1];
    }
}