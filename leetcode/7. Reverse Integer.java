class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int last = x % 10;      // 取余
            // 向上溢出、向下溢出
            if((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE && last > 7)) return 0;
            if((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE && last < 8)) return 0;
            ans = ans * 10 + last;  // 倒置求数
            x = x / 10;         // 缩小
        }
        return ans;
    }
}