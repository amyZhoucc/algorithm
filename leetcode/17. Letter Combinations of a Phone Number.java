class Solution {        // ���ö����������
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new LinkedList<String>();      // �����������

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> queue = new LinkedList<String>();      // ���ƴ�ӵ��ַ���
        queue.offer("");                // ���ȷ���һ�����ַ�������Ϊ��ʼ
        for(int i = 0; i < digits.length(); i++){
            int size = queue.size();         // ��ǰ�Ķ����е�Ԫ�ظ���������Ҫ�ں�����ַ��ĸ���
            String num_map = map[digits.charAt(i) - '0'];      // ���ӳ�����ĸ�ַ���
            for(int j = 0; j < size; j++){          // ����size������Ҫadd���ַ���
                String curr = queue.poll();         // ������ǰ�ַ���
                for(int k = 0; k < num_map.length(); k++){  // "a"+"d"/"e"/"f"
                    String temp = curr + num_map.charAt(k);   
                    queue.offer(temp);      // Ȼ������ѹ�������
                }
            }
        }
        return queue;
    }
}