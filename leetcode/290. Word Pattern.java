class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss;
        ss = s.split(" ");      // ���ַ����ָ�
        HashMap<Character, String>hash = new HashMap<Character, String>();  // key-value
        int i = 0;
        if(ss.length != pattern.length()) return false;       // �����������
        while(i < pattern.length() && i < ss.length){
            if(hash.containsKey(pattern.charAt(i))){        // ��ĸ���ֹ�����ô���ַ���Ӧ����ƥ���
                if(!(hash.get(pattern.charAt(i))).equals(ss[i]))
                    return false;
            }
            else{       // ��ĸδ���ֹ�
                if(hash.containsValue(ss[i]))
                    return false;     // �ַ���Ҳ���ܳ��ֹ�
                hash.put(pattern.charAt(i), ss[i]);
            }
            i++;
        }
        return true;
    }
}