class Solution {            // �ҵĽⷨ
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){       // s�е��ַ��Ѿ����ڹ���
                if(map.get(s.charAt(i)) != t.charAt(i)) // s��Ӧ��value�����ڵ�ǰֵ
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

class Solution {            // ���α�����sΪkey��tΪvalueһ�Σ�������һ��
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

