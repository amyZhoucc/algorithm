class Solution {
    public int[] singleNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){         // һ�α���������
            count ^= num;           // �������single���ֵ����ֵ>0
        }
        int mask = 1;
        while((mask & count) == 0){     // �ҵ��������ֵĵ�һ��0/1��ͬ��λ��������
            mask <<= 1;
        }
        int a = 0, b = 0;           // ��Ϊa��b����
        for(int num: nums){         
            if((num & mask) == 0){      // �ܽ�����single��������a��b�У�����������һ����a��b�г������Ρ�����Ϊ�ظ����ε�ԭ��
                a ^= num;
            }
            else
                b ^= num;
        }
        return new int[]{a, b};     // ������������
    }
}