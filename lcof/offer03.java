class Solution {        // �ҵĽⷨ�������ⷨ����ʱ�临�Ӷ�O(NlogN)
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(prev == nums[i]) return nums[i];
            prev = nums[i];
        }
        return -1;
    }
}

class Solution {                // ��ϣ��ⷨ
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();        // ������ϣ����д洢��setҲ���ԣ�
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], 1);
        }
        return -1;
    }
}

class Solution {            // һ���ܲ�һ���ӽⷨ
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int temp;
            while(nums[i] != i){			// һ���ܲ�һ���Ӳ���
                if(nums[i] == nums[nums[i]]) return nums[i]; // �������ظ�����
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}