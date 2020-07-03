class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int last = x % 10;      // ȡ��
            // ����������������
            if((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE && last > 7)) return 0;
            if((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE && last < 8)) return 0;
            ans = ans * 10 + last;  // ��������
            x = x / 10;         // ��С
        }
        return ans;
    }
}