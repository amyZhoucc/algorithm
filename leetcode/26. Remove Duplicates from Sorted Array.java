class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;      // �ų�����Ϊ�յ����

        int first = 0, second = 0;  // ����˫ָ�룬first����������second����ָʾ���½��
        for(; first < nums.length; first++){
            if(nums[second] != nums[first]){ // �������ȣ���second�Ϳ��������һλ�����Ҹ�������
                second++;
                nums[second] = nums[first];
            }
        }
        second++;       // second��Ҫָʾ����������+1
        return second;
    }
}