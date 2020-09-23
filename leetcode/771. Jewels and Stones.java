class Solution {            // 暴力求解，时间复杂度为O(m*n)
    public int numJewelsInStones(String J, String S) {          
        int sum = 0;
        for(char j: J.toCharArray()){
            for(char s: S.toCharArray()){
                if(j == s) sum++;
            }
        }
        return sum;
    }
}

class Solution {               // 哈希表辅助求解，时间复杂度O(m+n)
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        HashSet<Character> collect = new HashSet<>();       // 创建一个hash集合，基于hasmap来实现的，不允许有重复的元素
        for(char j: J.toCharArray()){                       // 遍历string，然后加入到hashset中
            collect.add(j);
        }
        for(char s: S.toCharArray()){                       // 然后去遍历string S，看每个元素在hashset中是否存在
            if(collect.contains(s)) sum++;  // 该操作的时间复杂度为O(1)
        }
        return sum;
    }
}