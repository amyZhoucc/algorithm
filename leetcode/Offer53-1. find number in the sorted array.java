class Solution {
    public static int leftbound(int[] nums, int target){    // ����߽�
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        int mid;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(nums[mid] == target) right = mid;
            else if(nums[mid] < target) left = mid + 1; // target̫������Ҫ��С��߽�
            else if(nums[mid] > target) right = mid;    // target̫С������Ҫ��С�ұ߽�
        }
        if(left == nums.length) return -1;
        return nums[left] ==  target ? left: -1;
    }
    public static int rightbound(int[] nums, int target){   // ���ұ߽�
        if(nums.length == 0) return -1;
        int left = 0; 
        int right = nums.length;
        int mid;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(nums[mid] == target) left = mid + 1;
            else if(nums[mid] < target) left =  mid + 1;    // target̫������Ҫ��С��߽�
            else if(nums[mid] > target) right = mid;    // target̫С������Ҫ��С�ұ߽�
        }
        if(left == 0) return -1;
        return nums[left - 1] == target ? left - 1: -1;
    }
    public int search(int[] nums, int target) {
        int left = leftbound(nums, target);     // ��߽��ֵ
        int right = rightbound(nums, target);   // �ұ߽��ֵ
        if(left == -1 || right == -1) return 0; // �ų��������
        return right - left + 1;
    }
}