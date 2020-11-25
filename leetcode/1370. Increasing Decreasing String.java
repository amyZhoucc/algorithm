class Solution {            // 桶计数
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){        // 统计每个字符出现次数
            count[s.charAt(i) - 'a']++;
        }
        StringBuffer buf = new StringBuffer();
        boolean flag = true;    // true表示升序添加；false表示降序
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
        return buf.toString();      // 转换成字符串
    }
}

class Solution {            // 稍微优化版本：主要去除了flag判断——每次while循环都执行一遍顺序搜索和逆序搜索（而之前的方法是，要么顺序要么逆序）
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