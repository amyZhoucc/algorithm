package leetcode_algorithm;

 class Solution {
	    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        int len = candies.length;   // 求数组长度
	        int maxCandies = 0;     // 存放最大糖果数（未给额外糖果时）

	        for(int i = 0; i < len; i++){           //  求最大糖果数
	            // if (maxCandies <= candies[i]) 
	            //     maxCandies = candies[i];
	            maxCandies = Math.max(maxCandies, candies[i])   // 调用函数 Math.max 求
	        }

	        List<Boolean> ret = new ArrayList<Boolean>();    // 新建一个结果数组
	        for(int i = 0; i < len; i++){                   // 遍历，判断加上extra是否能达到最大
	            if (candies[i] + extraCandies >= maxCandies)
	                ret.add(true);                          // 加入数组
	            else
	                ret.add(false);                 
	        }
	        return ret;
	    }
	}