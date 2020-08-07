class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;      // ��ȥ����ֵ
        int left = 1;           // ��������ָ�룬ָʾ������
        int right = x - 1;
        int mid;
        while(left <= right){       // ����ѭ������
            mid = ((right - left) >> 1) + left;
            if((long)mid * mid == x) {  // �ҵ����⣬ֱ�ӷ���
                return mid;
            }
            else if((long)mid * mid < x){   // ��С��߽�
                left = mid + 1;
            }   
            else{           // ��С�ұ߽�
                right = mid - 1;
            }
        }
        // ѭ��ֹͣʱ��left = right + 1����ô�������left - 1
        return left - 1;
    }
}