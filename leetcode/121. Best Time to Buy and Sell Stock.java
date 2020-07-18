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
        for(int i = 1; i < prices.length; i++){         // 卖出时机
            minprice = minprice < prices[i-1] ? minprice : prices[i-1]; // 更新历史最低值
            int temp = prices[i] - minprice;
            maxpro = maxpro > temp ? maxpro : temp;
        }
        return maxpro;
    }
}