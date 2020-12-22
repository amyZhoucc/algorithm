class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss;
        ss = s.split(" ");      // 将字符串分割
        HashMap<Character, String>hash = new HashMap<Character, String>();  // key-value
        int i = 0;
        if(ss.length != pattern.length()) return false;       // 处理特殊情况
        while(i < pattern.length() && i < ss.length){
            if(hash.containsKey(pattern.charAt(i))){        // 字母出现过，那么该字符串应该是匹配的
                if(!(hash.get(pattern.charAt(i))).equals(ss[i]))
                    return false;
            }
            else{       // 字母未出现过
                if(hash.containsValue(ss[i]))
                    return false;     // 字符串也不能出现过
                hash.put(pattern.charAt(i), ss[i]);
            }
            i++;
        }
        return true;
    }
}