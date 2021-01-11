class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        StringBuilder sb = new StringBuilder(num);  // 因为需要不断删除合并，所以转成字符流更适合一点
        
        for(int i = 0; i < k; i++){
            int j = 1;
            for(; j < sb.length() && sb.charAt(j-1) <= sb.charAt(j); j++);
            sb.delete(j-1, j);              // 每次都保证有且只删除一个
            while(sb.length() > 1 && sb.charAt(0)== '0') sb.delete(0, 1);   // 抹去开头的0不算在删除里面
        }
        return sb.toString();
    }
}