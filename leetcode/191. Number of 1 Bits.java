public class Solution {         // ����ⷨ
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 0;
        int mask = 1;               // ����
        for(int i = 1; i <= 32; i++){
            if((n & mask) != 0) bit++;          //��Ӧ����λ��1
            mask <<= 1;
        }
        return bit;
    }
}

public class Solution {         // С���ɽⷨ
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 0;
        while(n != 0){
            bit++;
            n &= (n - 1);           // ÿ�κ�n-1���룬��������n�����һ��1
        }
        return bit;
    }
}