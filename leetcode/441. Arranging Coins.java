class Solution {				// ��ѧ�ⷨ��ԭ���ǣ�(1+x)x/2<=n��Ȼ�����ýⷽ�̹�ʽ���
    public int arrangeCoins(int n) {
        int sq = (int)(Math.sqrt((long)n*8+1));
        return (-1 + sq)/2;
    }
}

class Solution {				// ���ֲ��ҷ�����1~n���в��ң��ж�(1+mid)*mid/2��n�Ĵ�С�Ƚϣ���Ҫע��������������
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        long mid;
        while(left <= right){
            mid = left + (right - left)/2;
            long temp = ((mid + 1) * mid) / 2;
            if(temp == n) return (int)mid;
            else if(temp < n) left = (int)mid + 1;
            else if(temp > n) right = (int)mid - 1;
        }
        return left - 1;
    }
}

class Solution {				// �������
    public int arrangeCoins(int n) {
        int i;
        for(i = 1; n >= 0; i++){
            n -= i;
        }
        return i-2;
    }
}