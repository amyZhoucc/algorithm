public class Solution {         // 笨蛋解法
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 16; i++){
            if(i == 0){             // 特殊处理最高位和最低位——因为存在负数的情况
                if(((1 << (31 - i)) & n) != 0) res |= 1;        // 如果最高位为负数，那么不能直接移位，因为是负数——移位全部补1，所以手动操作对应的最低位为1
                int right = ((1 << i) & n) << (31-i-i);         // right和下面同操作
                res = res ^ right;
                continue;
            }
            int left = ((1 << (31 - i)) & n) >> (31-i-i);   // 左侧的位通过掩码得到，然后右移到右侧对应位置
            int right = ((1 << i) & n) << (31-i-i);         // 右侧的位通过掩码得到，然后左移到左侧对应的位置
            res = res ^ left ^ right;           // 然后异或一下，0^任何数就是其本身
        }
        return res;
    }
}

public class Solution {        // 类似于整数逆序的求法
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){    // 辗转相除（移位），然后将最低位移到最高位
            int temp = n & 1;       
            n = n >> 1;
            res = (res << 1) + temp;    // 也可以用：res = (res << 1) ^ temp;
        }
        return res;
    }
}