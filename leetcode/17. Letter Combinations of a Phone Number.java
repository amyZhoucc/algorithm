class Solution {        // 利用队列特性求解
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new LinkedList<String>();      // 处理特殊情况

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> queue = new LinkedList<String>();      // 存放拼接的字符串
        queue.offer("");                // 首先放入一个空字符串，作为开始
        for(int i = 0; i < digits.length(); i++){
            int size = queue.size();         // 求当前的队列中的元素个数，就是要在后面加字符的个数
            String num_map = map[digits.charAt(i) - '0'];      // 求出映射的字母字符串
            for(int j = 0; j < size; j++){          // 根据size遍历需要add的字符串
                String curr = queue.poll();         // 弹出当前字符串
                for(int k = 0; k < num_map.length(); k++){  // "a"+"d"/"e"/"f"
                    String temp = curr + num_map.charAt(k);   
                    queue.offer(temp);      // 然后重新压入队列中
                }
            }
        }
        return queue;
    }
}