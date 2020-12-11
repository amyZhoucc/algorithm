class Solution {            // 我的解法
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        LinkedList<Character>stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c =='{') stack.offerLast(c);     // 如果是左侧的，那就压入栈
            else if(c == ')' || c == ']' || c =='}') {          // 如果是右侧的，那么就出栈，然后进行匹配
                if(stack.size() == 0) return false;     // 如果栈为空，说明左符号少，直接false
                char temp = stack.pollLast();           
                if(c == ')' && temp != '(') return false;       // 如果弹出的，和当前的不匹配，直接返回false
                if(c == ']' && temp != '[') return false;
                if(c == '}' && temp != '{') return false;
            }
        }
        if(stack.size() != 0) return false;     // 如果栈中还有元素，说明左侧符号多，返回false
        else return true;
    }
}

class Solution {            // 优化：思想上一样
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        LinkedList<Character>stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.offerLast(')');          // 反向思维，压入栈的是其对应的符号，那么只需要匹配即可
            else if(c == '[') stack.offerLast(']');
            else if(c == '{') stack.offerLast('}');
            else if(stack.size() == 0 || c != stack.pollLast()) return false;
        }
        if(stack.size() != 0) return false;
        else return true;
    }
}