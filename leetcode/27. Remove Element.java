package leetcode_algorithm;

class Solution {
    public int removeElement(int[] nums, int val) {
        int first = 0, second = 0;  // ����ָ�룬һ����ǰ�������һ��������ָ��
        for(; first < nums.length; first++){     // ���� 
            if(nums[first] != val){             // �������ȣ��͸���second����ȣ��Ͳ�����second
                nums[second] = nums[first];		// ���������
                second++;
            }
        }
        return second;
    }
}

class secondSolution {					// ������Ҫɾ����Ԫ�رȽ���ʱ
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){					// ����ָ��û������
            if(nums[i] == val){			// ��������Ҫɾ������ô��β����Ԫ���滻��ǰ��
                nums[i] = nums[n - 1];
                n--;					// ����β��ָ�����
            }
            else{
                i++;					// ����Ⱦ͸���ͷָ��
            }
        }
        // ���˲�������ָ�������ˣ�˵������� i �ĳ���
        return i;
    }
}