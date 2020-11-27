class Solution {            // ���Խⷨ
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i] - nums[i - 1];
            maxGap = temp > maxGap ? temp : maxGap;
        }
        return maxGap;
    }
}

class Solution {                // ��������
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;       // �����������

        int max = Arrays.stream(nums).max().getAsInt(); // ������ֵ
        int exp = 1;
        while(max >= exp){
            int[] temp = new int[10];   // ��ż����ģ�����ÿһλ��0~9����
            int[] cpy = new int[len];
            for(int i = 0; i < len; i++){
                int digit = (nums[i] / exp) % 10;   // ȡĳһλ
                temp[digit]++;      // ��Ӧ������++
            }
            for(int i = 1; i < 10; i++){
                temp[i] += temp[i - 1];     // �����ڼ������������ǰ������������������λ��
            }
            // ע������˳������ǰ���λ���Ѿ�������ģ���ô����Ҫ������Ĳ��롪�����Ų壨�����������ȶ��ģ��������ڴˣ�
            for(int i = len - 1; i >= 0; i--){          
                int digit = (nums[i] / exp) % 10;
                cpy[temp[digit] - 1] = nums[i];
                temp[digit]--;
            }
            System.arraycopy(cpy, 0, nums, 0, len);
            exp *= 10;  // exp�����ô��������һλ
        }
        
        // ����֮��������϶
        int maxGap = 0;
        for(int i = 0; i < len - 1; i++){
            if(maxGap < nums[i + 1] - nums[i]) maxGap = nums[i + 1] - nums[i];
        }
        return maxGap;
    }
}