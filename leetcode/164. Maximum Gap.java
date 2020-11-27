class Solution {            // 无脑解法
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i] - nums[i - 1];
            maxGap = temp > maxGap ? temp : maxGap;
        }
        return maxGap;
    }
}

class Solution {                // 基数排序
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;       // 处理特殊情况

        int max = Arrays.stream(nums).max().getAsInt(); // 获得最大值
        int exp = 1;
        while(max >= exp){
            int[] temp = new int[10];   // 存放计数的，代表每一位的0~9数字
            int[] cpy = new int[len];
            for(int i = 0; i < len; i++){
                int digit = (nums[i] / exp) % 10;   // 取某一位
                temp[digit]++;      // 对应的数字++
            }
            for(int i = 1; i < 10; i++){
                temp[i] += temp[i - 1];     // 类似于计数排序，算出当前数字在排序中所处的位置
            }
            // 注意插入的顺序，由于前面的位数已经是有序的，那么还是要按有序的插入——倒着插（计数排序是稳定的，就体现在此）
            for(int i = len - 1; i >= 0; i--){          
                int digit = (nums[i] / exp) % 10;
                cpy[temp[digit] - 1] = nums[i];
                temp[digit]--;
            }
            System.arraycopy(cpy, 0, nums, 0, len);
            exp *= 10;  // exp变大，那么能向上找一位
        }
        
        // 排序之后求最大间隙
        int maxGap = 0;
        for(int i = 0; i < len - 1; i++){
            if(maxGap < nums[i + 1] - nums[i]) maxGap = nums[i + 1] - nums[i];
        }
        return maxGap;
    }
}