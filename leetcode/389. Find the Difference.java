class Solution {            // �ٷ��ⷨ����
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}

class Solution {        // ����΢�Ż�
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) return t.charAt(0);     // �������������tһ����s��1����ĸ

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        count[t.charAt(t.length() - 1) - 'a']--;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0) return (char)((int)'a' + i);
        }
        return ' ';
    }
}

class Solution {        // ���
    public char findTheDifference(String s, String t) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count -= s.charAt(i);
            count += t.charAt(i);
        }
        count += t.charAt(t.length() - 1);
        return (char)count;
    }
}

class Solution {        // ������
    public char findTheDifference(String s, String t) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count ^= s.charAt(i);
            count ^= t.charAt(i);
        }
        count ^= t.charAt(t.length() - 1);
        return (char)count;
    }
}