class Solution {        // �ҵĽⷨ�������ⷨ����ʱ�临�Ӷ�O(NlogN)
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]) return nums[i];
        }
        return -1;
    }
}

class Solution {            // Ĥ�ݵĽⷨ����TM��Ű�����ʱ�临�Ӷ�O(N)
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}