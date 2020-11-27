class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4) return res;     // �����������

        Arrays.sort(nums);          // ����
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){       // ��һ��ѭ��
            // if(nums[i] > target) return res;    // �����һ�����Ѿ�>Ŀ�ꡪ�����������򵥵��ж�
            if(i > 0 && nums[i] == nums[i - 1]) continue;   // ��һ�ص�ȥ��
            // ����һ��˵����0�������ظ���<Ŀ��
            for(int j = i + 1; j < len - 2; j++){
                // if((nums[i] + nums[j]) > target) return res;  //�����жϷ�����ȡ
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right]== nums[right - 1]) right--; 
                        left++;
                        right--;
                    }
                    else if(temp < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}

class Solution {            // ��֦һ��
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4) return res;     // �����������

        Arrays.sort(nums);          // ����
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){       // ��һ��ѭ��
            if(i > 0 && nums[i] == nums[i - 1]) continue;   // ��һ�ص�ȥ��
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;  // ��С�Ķ�����
            if(nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;  // ��i�£����Ķ�̫С
           
            // ����һ��˵����0�������ظ�����������
            for(int j = i + 1; j < len - 2; j++){
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue;
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if(nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;

                int left = j + 1, right = len - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(temp == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right]== nums[right - 1]) right--; 
                        left++;
                        right--;
                    }
                    else if(temp < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}