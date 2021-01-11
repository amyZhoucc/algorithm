class Solution {            // 我的解法
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){       // s中的字符已经存在过了
                if(map.get(s.charAt(i)) != t.charAt(i)) // s对应的value不等于当前值
                    return false;
            }
            else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}

class Solution {            // 两次遍历，s为key，t为value一次；逆着再一次
    public boolean helpFun(String key, String value){
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < key.length(); i++){
            if(map.containsKey(key.charAt(i))){
                if(map.get(key.charAt(i)) != value.charAt(i)) return false;
            }
            else{
                map.put(key.charAt(i), value.charAt(i));
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        return helpFun(s, t) && helpFun(t, s);
    }
}

