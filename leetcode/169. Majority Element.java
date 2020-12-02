class Solution {            // 排序求中间值法，时间复杂度O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

class Solution {            // 使用hash表存储nums出现的次数，然后遍历hash表求出众数
    private  Map<Integer, Integer> countNumber(int[] nums){
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(!count.containsKey(num))     // 如果哈希表中不包含该数，那么加入，并value置1
                count.put(num, 1);
            else                            // 如果包含该数，那么对应的value++
                count.put(num, count.get(num) + 1); 
        }
        return count;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = countNumber(nums);    // 遍历数组，将值放入哈希表中
        Map.Entry<Integer, Integer>majority = null;
        for(Map.Entry<Integer, Integer>entry: count.entrySet()){
            if(majority == null || majority.getValue() < entry.getValue()){
                majority = entry;
            }
        }
        return majority.getKey();
    }
}

class Solution {            // 分治法
    private int countInArray(int[] nums, int left, int right, int value){
        int count = 0;
        for(int i = left; i <= right; i++){
            if(value == nums[i]) count++;
        }
        return count;
    }
    private int majorityFind(int[] nums, int left, int right){
        if(left == right) return nums[left];        // 如果数组中只有一个元素，那么它一定为众数

        int mid = (right - left) / 2 + left;        // 求出中间值
        int leftValue = majorityFind(nums, left, mid);        // 递归去找其分段的众数
        int rightValue = majorityFind(nums, mid + 1, right);
        
        int leftNum,rightNum;
        if(leftValue == rightValue){
            return leftValue;   // 如果左右众数一样，那么就返回
        }
        else{           // 如果众数不一样，就看在此范围内，哪个出现次数更多
            leftNum = countInArray(nums, left, right, leftValue);
            rightNum = countInArray(nums, left, right, rightValue);
        }
        return leftNum > rightNum? leftValue : rightValue;
    }
    public int majorityElement(int[] nums) {
        return majorityFind(nums, 0, nums.length - 1);
    }
}

class Solution {           // 投票算法
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int num : nums){
            if(count == 0) candidate = num; 
            if(candidate != num)
                count--;
            else
                count++;
        }
        return candidate;
    }
}