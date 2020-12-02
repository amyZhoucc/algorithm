class Solution {        // 暴力解
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
}

class Solution {        // 快排partition解
    private int partition(int[] nums, int left, int right){ //
        int compare = nums[right];
        while(left < right){
            while(left < right && nums[left] <= compare) left++;
            if(left < right) nums[right--] = nums[left];
            while(left < right && nums[right] >= compare) right--;
            if(left < right) nums[left++] = nums[right];
        }
        nums[left] = compare;
        return left;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;       // 第k大元素所在的index值
        int left = 0, right = nums.length - 1;
        while(true){
            int index = partition(nums, left, right);
            if(index == target) return nums[index];
            else if(index < target) left = index + 1;
            else right = index - 1;
        }
        
    }
}

class Solution {           // 快排优化解
    private static Random random = new Random(System.currentTimeMillis());
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    private int partition(int[] nums, int left, int right){ // 快速排序的切分
        if(left < right){
            int randIndex = right - (random.nextInt(right - left) + 1);
            swap(nums, randIndex, right);       // 交换两者的值
        }
        int compare = nums[right];
        while(left < right){
            while(left < right && nums[left] <= compare) left++;
            if(left < right) nums[right--] = nums[left];
            while(left < right && nums[right] >= compare) right--;
            if(left < right) nums[left++] = nums[right];
        }
        nums[left] = compare;
        return left;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;       // 第k大元素所在的index值
        int left = 0, right = nums.length - 1;
        while(true){
            int index = partition(nums, left, right);
            if(index == target) return nums[index];
            else if(index < target) left = index + 1;   // 切分的点比目标点要小，那么目标点的值更大，所以找后半部分
            else right = index - 1;           // 切分点比目标点大，那么目标点的值更小，所以找前半部分
        }
        
    }
}

class Solution {        // 最小堆解法
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(len, (a, b)-> a - b);
        for(int i = 0; i < len; i++){
            minHeap.add(nums[i]);
        }
        for(int i = 0; i < len - k; i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}