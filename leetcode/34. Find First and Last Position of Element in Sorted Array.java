class Solution {
    // �������߽�
    public static int leftboundSearch(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0;       // �������ҡ���ָ��
        int right = nums.length;
        int mid;
        while(left < right){    // ����ѭ����ֹ����
            mid = ((right - left) >> 1) + left; // �����м�ָ��
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
        if(left == nums.length) return -1;		// �ѱ߽������ų�
        return nums[left] == target ? left: -1; // ȷ��ָ����Ƿ�ʱ����or����ѭ����ֹ�ĵ�
    }
    // �����Ҳ�߽�
    public static int rightboundSearch(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0;       // �������ҡ���ָ��
        int right = nums.length;
        int mid;
        while(left < right){     // ����ѭ����ֹ����
            mid = ((right - left) >> 1) + left;	// �����м�ָ��
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
        if(left == 0) return -1;		// �ѱ߽������ų�
        return nums[left - 1] == target ? left - 1: -1; // ȷ��ָ����Ƿ�ʱ����or����ѭ����ֹ�ĵ�
    }
    public int[] searchRange(int[] nums, int target) {
        int[] bounds = new int[2];
        bounds[0] = leftboundSearch(nums, target);
        bounds[1] = rightboundSearch(nums, target);
        return bounds;
    }
}