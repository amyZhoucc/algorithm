class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int last = x % 10;      // ȡ��
            // ����������������������Ϊ��ϸ�ģ�2147483647_Integer.MAXVALUE,-2147483648_Integer.MINVALUE
            if((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE && last > 7)) return 0;
            if((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE && last < 8)) return 0;
            ans = ans * 10 + last;  // ��������
            x = x / 10;         // ��С
        }
        return ans;
    }
}

class Solution {            
    public int reverse(int x) {
        int res = 0;
        while(x != 0 ){
            if(res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0;      // ��ߵ�����ж�ֻ��һ�����
            int temp = x % 10;
            x /= 10;
            res = res * 10 + temp;
        }
        return res;
    }
}