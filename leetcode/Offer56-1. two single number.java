class Solution {
    public int[] singleNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){         // 一次遍历异或操作
            count ^= num;           // 获得两个single数字的异或值>0
        }
        int mask = 1;
        while((mask & count) == 0){     // 找到两个数字的第一个0/1不同的位——掩码
            mask <<= 1;
        }
        int a = 0, b = 0;           // 分为a、b两组
        for(int num: nums){         
            if((num & mask) == 0){      // 能将两个single数区分在a、b中，并且其他数一定在a、b中出现两次——因为重复两次的原因
                a ^= num;
            }
            else
                b ^= num;
        }
        return new int[]{a, b};     // 创建返回数组
    }
}