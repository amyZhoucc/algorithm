class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;     // 长度不一样也直接返回

        int[] arr_s = new int[26];      // 创建两个数组，分别存放s和t的对应字符
        int[] arr_t = new int[26];  
        for(int i = 0; i < s.length(); i++){
            arr_s[s.charAt(i) - 'a']++;
            arr_t[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr_s[i] != arr_t[i]) return false;
        }
        return true;
    }
}