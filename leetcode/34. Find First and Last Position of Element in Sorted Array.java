class Solution {
    // 查找左侧边界
    public static int leftboundSearch(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0;       // 设置左、右、中指针
        int right = nums.length;
        int mid;
        while(left < right){    // 设置循环终止条件
            mid = ((right - left) >> 1) + left; // 设置中间指针
            if(target == nums[mid]){
                right = mid;
            }
            else if(target < nums[mid]){
                right = mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        if(left == nums.length) return -1;		// 把边界条件排除
        return nums[left] == target ? left: -1; // 确认指向的是否时正解or被迫循环终止的点
    }
    // 查找右侧边界
    public static int rightboundSearch(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0;       // 设置左、右、中指针
        int right = nums.length;
        int mid;
        while(left < right){     // 设置循环终止条件
            mid = ((right - left) >> 1) + left;	// 设置中间指针
            if(target == nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        if(left == 0) return -1;		// 把边界条件排除
        return nums[left - 1] == target ? left - 1: -1; // 确认指向的是否时正解or被迫循环终止的点
    }
    public int[] searchRange(int[] nums, int target) {
        int[] bounds = new int[2];
        bounds[0] = leftboundSearch(nums, target);
        bounds[1] = rightboundSearch(nums, target);
        return bounds;
    }
}