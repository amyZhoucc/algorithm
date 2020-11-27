class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length < 3) return res;       // �ų��������

        Arrays.sort(nums);          // ������
        for(int i = 0; i < nums.length - 2; i++){       // �̶���ǰ��
            if(nums[i] > 0) return res;     // ����������󣬽�����Ӳ�����
            if(i > 0 && nums[i] == nums[i - 1]) continue;// �����ǰ����ǰһ��һ������ô�����˴�
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // ֱ���ҵ���֮ǰ��һ���ģ�Ϊ�˱�֤*��һ��*�Ľ����ȷ��ע��߽���������Ҫ���ϣ�
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    // ���û����ô[0, 0, 0, 0]����һֱ��ѭ����right - 1=-1������Ż�ֹͣ
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if(sum > 0) right--;   // ���̫����ô��ָ���ƶ�
                else left++;        // ���̫С����ô��ָ���ƶ�
            }
        }
        return res;
    }
}