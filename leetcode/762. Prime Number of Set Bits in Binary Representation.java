class Solution {           // 我的解法
    int[] prime = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};    // prime计数——由于数限制在10^6范围内，所以对应的位数不超过19位，所以就写前19个数字中的质数查表即可
    private boolean isPrime(int n){         // 实现了一个求n的bit位数，然后查表计算位数是否是一个质数值
        int bit = 0;
        while(n != 0){
            if(n % 2 == 1) bit++;
            n >>= 1;
        }
        return prime[bit] == 1;
    }
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++){
            if(isPrime(i)) count++;
        }
        return count;
    }
}

class Solution {            // 优化解法
    int[] prime = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};    
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++){
            count += prime[Integer.bitCount(i)];        // 直接调用库函数
        }
        return count;
    }
}