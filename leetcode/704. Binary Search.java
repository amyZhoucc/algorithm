class Solution {		// �����⣬ʱ�临�Ӷ�ΪO(n)
    public int searchInsert(int[] nums, int target) {
        int i;
         for(i = 0;  i < nums.length; i++){
             if(target <= nums[i])  return i;
         }
         return i;
    }
}

class Solution {		// �Ľ����ö��ֲ��ң�ʱ�临�Ӷ�ΪO(logn)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;    // ��¼���鳤��
        int left = 0, right = n - 1, mid;   // ��������ָ�룬����������
        int ans = n; 	// �𰸳�ʼ��Ϊn���ؼ����������ܷ�ֹ��Ϊ�����λ����������Ҫ�Ķ����ж�
        while(left <=  right){  // ѭ������
            mid = ((right -  left)>>1) + left;	// �������Է�ֹ�������֮������
            if(target <= nums[mid]){
                right = mid - 1;	// �߽���������
                ans = mid;			// �ϸ�С��target�������������ǽ⣬ֻ�д���target�������п��ܣ��Ӷ���������
            }
            else{
                left = mid + 1;		// С��target��ֱ�ӱ߽���������
            }
        }  
        return ans;
    }
}