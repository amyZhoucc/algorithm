class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0, second = 0;  // ������ָʾ������������һ������ֵ
        for(; first < nums.length; first++){
            if(nums[first] == 0)        // �����������0��ֱ������
                continue;
            else{                   // �����Ĳ���0����ô�ƶ�
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                second++;
                
            }
        }
    }
}