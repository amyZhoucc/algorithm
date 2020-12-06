public class Solution {         // 掩码解法
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 0;
        int mask = 1;               // 掩码
        for(int i = 1; i <= 32; i++){
            if((n & mask) != 0) bit++;          //对应掩码位是1
            mask <<= 1;
        }
        return bit;
    }
}

public class Solution {         // 小技巧解法
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 0;
        while(n != 0){
            bit++;
            n &= (n - 1);           // 每次和n-1相与，都能消掉n的最后一个1
        }
        return bit;
    }
}