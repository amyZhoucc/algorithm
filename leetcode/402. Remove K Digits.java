class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        StringBuilder sb = new StringBuilder(num);  // ��Ϊ��Ҫ����ɾ���ϲ�������ת���ַ������ʺ�һ��
        
        for(int i = 0; i < k; i++){
            int j = 1;
            for(; j < sb.length() && sb.charAt(j-1) <= sb.charAt(j); j++);
            sb.delete(j-1, j);              // ÿ�ζ���֤����ֻɾ��һ��
            while(sb.length() > 1 && sb.charAt(0)== '0') sb.delete(0, 1);   // Ĩȥ��ͷ��0������ɾ������
        }
        return sb.toString();
    }
}