class Solution {        // 我的解法（笨蛋解法），时间复杂度O(NlogN)
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(prev == nums[i]) return nums[i];
            prev = nums[i];
        }
        return -1;
    }
}

class Solution {                // 哈希表解法
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();        // 创建哈希表进行存储（set也可以）
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], 1);
        }
        return -1;
    }
}

class Solution {            // 一个萝卜一个坑解法
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int temp;
            while(nums[i] != i){			// 一个萝卜一个坑操作
                if(nums[i] == nums[nums[i]]) return nums[i]; // 出现了重复数字
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}