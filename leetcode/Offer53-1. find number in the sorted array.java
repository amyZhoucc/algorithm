class Solution {
    public static int leftbound(int[] nums, int target){    // 求左边界
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        int mid;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(nums[mid] == target) right = mid;
            else if(nums[mid] < target) left = mid + 1; // target太大，所以要缩小左边界
            else if(nums[mid] > target) right = mid;    // target太小，所以要缩小右边界
        }
        if(left == nums.length) return -1;
        return nums[left] ==  target ? left: -1;
    }
    public static int rightbound(int[] nums, int target){   // 求右边界
        if(nums.length == 0) return -1;
        int left = 0; 
        int right = nums.length;
        int mid;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(nums[mid] == target) left = mid + 1;
            else if(nums[mid] < target) left =  mid + 1;    // target太大，所以要缩小左边界
            else if(nums[mid] > target) right = mid;    // target太小，所以要缩小右边界
        }
        if(left == 0) return -1;
        return nums[left - 1] == target ? left - 1: -1;
    }
    public int search(int[] nums, int target) {
        int left = leftbound(nums, target);     // 左边界的值
        int right = rightbound(nums, target);   // 右边界的值
        if(left == -1 || right == -1) return 0; // 排除特殊情况
        return right - left + 1;
    }
}