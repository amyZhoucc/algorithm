class Solution {		// 暴力解，时间复杂度为O(n)
    public int searchInsert(int[] nums, int target) {
        int i;
         for(i = 0;  i < nums.length; i++){
             if(target <= nums[i])  return i;
         }
         return i;
    }
}

class Solution {		// 改进后，用二分查找，时间复杂度为O(logn)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;    // 记录数组长度
        int left = 0, right = n - 1, mid;   // 设置三个指针，代表左右中
        int ans = n; 	// 答案初始化为n（关键），这样能防止因为插入的位置在最后而需要的额外判断
        while(left <=  right){  // 循环条件
            mid = ((right -  left)>>1) + left;	// 这样可以防止大数相加之后的溢出
            if(target <= nums[mid]){
                right = mid - 1;	// 边界向左收缩
                ans = mid;			// 严格小于target的数，不可能是解，只有大于target的数才有可能，从而不断收缩
            }
            else{
                left = mid + 1;		// 小于target，直接边界向右收缩
            }
        }  
        return ans;
    }
}