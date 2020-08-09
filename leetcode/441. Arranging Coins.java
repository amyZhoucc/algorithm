class Solution {				// 数学解法，原理是：(1+x)x/2<=n，然后利用解方程公式求解
    public int arrangeCoins(int n) {
        int sq = (int)(Math.sqrt((long)n*8+1));
        return (-1 + sq)/2;
    }
}

class Solution {				// 二分查找法，从1~n进行查找，判断(1+mid)*mid/2和n的大小比较，需要注意大数的溢出问题
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        long mid;
        while(left <= right){
            mid = left + (right - left)/2;
            long temp = ((mid + 1) * mid) / 2;
            if(temp == n) return (int)mid;
            else if(temp < n) left = (int)mid + 1;
            else if(temp > n) right = (int)mid - 1;
        }
        return left - 1;
    }
}

class Solution {				// 暴力求解
    public int arrangeCoins(int n) {
        int i;
        for(i = 1; n >= 0; i++){
            n -= i;
        }
        return i-2;
    }
}