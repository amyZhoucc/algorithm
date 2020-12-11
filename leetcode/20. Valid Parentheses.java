class Solution {            // �ҵĽⷨ
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        LinkedList<Character>stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c =='{') stack.offerLast(c);     // ��������ģ��Ǿ�ѹ��ջ
            else if(c == ')' || c == ']' || c =='}') {          // ������Ҳ�ģ���ô�ͳ�ջ��Ȼ�����ƥ��
                if(stack.size() == 0) return false;     // ���ջΪ�գ�˵��������٣�ֱ��false
                char temp = stack.pollLast();           
                if(c == ')' && temp != '(') return false;       // ��������ģ��͵�ǰ�Ĳ�ƥ�䣬ֱ�ӷ���false
                if(c == ']' && temp != '[') return false;
                if(c == '}' && temp != '{') return false;
            }
        }
        if(stack.size() != 0) return false;     // ���ջ�л���Ԫ�أ�˵�������Ŷ࣬����false
        else return true;
    }
}

class Solution {            // �Ż���˼����һ��
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        LinkedList<Character>stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.offerLast(')');          // ����˼ά��ѹ��ջ�������Ӧ�ķ��ţ���ôֻ��Ҫƥ�伴��
            else if(c == '[') stack.offerLast(']');
            else if(c == '{') stack.offerLast('}');
            else if(stack.size() == 0 || c != stack.pollLast()) return false;
        }
        if(stack.size() != 0) return false;
        else return true;
    }
}