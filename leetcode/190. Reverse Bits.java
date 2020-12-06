public class Solution {         // �����ⷨ
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 16; i++){
            if(i == 0){             // ���⴦�����λ�����λ������Ϊ���ڸ��������
                if(((1 << (31 - i)) & n) != 0) res |= 1;        // ������λΪ��������ô����ֱ����λ����Ϊ�Ǹ���������λȫ����1�������ֶ�������Ӧ�����λΪ1
                int right = ((1 << i) & n) << (31-i-i);         // right������ͬ����
                res = res ^ right;
                continue;
            }
            int left = ((1 << (31 - i)) & n) >> (31-i-i);   // ����λͨ������õ���Ȼ�����Ƶ��Ҳ��Ӧλ��
            int right = ((1 << i) & n) << (31-i-i);         // �Ҳ��λͨ������õ���Ȼ�����Ƶ�����Ӧ��λ��
            res = res ^ left ^ right;           // Ȼ�����һ�£�0^�κ��������䱾��
        }
        return res;
    }
}

public class Solution {        // �����������������
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){    // շת�������λ����Ȼ�����λ�Ƶ����λ
            int temp = n & 1;       
            n = n >> 1;
            res = (res << 1) + temp;    // Ҳ�����ã�res = (res << 1) ^ temp;
        }
        return res;
    }
}