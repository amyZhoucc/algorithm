class Solution {            // Ͱ����
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){        // ͳ��ÿ���ַ����ִ���
            count[s.charAt(i) - 'a']++;
        }
        StringBuffer buf = new StringBuffer();
        boolean flag = true;    // true��ʾ������ӣ�false��ʾ����
        while(buf.length() < s.length()){
            if(flag){
                for(int i = 0; i < 26; i++){
                    if(count[i] != 0){
                        char temp = (char)('a' + i);
                        buf.append(temp);
                        count[i]--;
                    }
                }
            }
            else{
                for(int i = 25; i >= 0; i--){
                    if(count[i] != 0){
                        char temp = (char)('a' + i);
                        buf.append(temp);
                        count[i]--;
                    }
                }
            }
            flag = !flag;
        }
        return buf.toString();      // ת�����ַ���
    }
}

class Solution {            // ��΢�Ż��汾����Ҫȥ����flag�жϡ���ÿ��whileѭ����ִ��һ��˳��������������������֮ǰ�ķ����ǣ�Ҫô˳��Ҫô����
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        StringBuffer buf = new StringBuffer();
        while(buf.length() < s.length()){
            for(int i = 0; i < 26; i++){
                if(count[i] != 0){
                    char temp = (char)('a' + i);
                    buf.append(temp);
                    count[i]--;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(count[i] != 0){
                    char temp = (char)('a' + i);
                    buf.append(temp);
                    count[i]--;
                }
            }
        }
        return buf.toString();
    }
}