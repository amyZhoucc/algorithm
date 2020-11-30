class CQueue {          // �ҵĽⷨ���������ⷨ
    private Stack<Integer>in = new Stack<Integer>();    // ��ջ1
    private Stack<Integer>out = new Stack<Integer>();   // ��ջ2
    public CQueue() {
    }
    
    public void appendTail(int value) {     // ����Ҫ����ѹ��ջ
        in.push(new Integer(value));
    }
    
    public int deleteHead() {
        if(in.empty()) return -1;   // ջΪ�գ�ֱ�ӷ���-1
        while(!in.empty()){         // inȫ����ջ���ŵ�out��
            Integer temp = in.pop();
            out.push(temp);
        }
        Integer target = out.pop();     // ��out��ջ��������in��ջ�ף������Ƕ���
        while(!out.empty()){        // outȫ����ջ���Żص�in��
            Integer temp = out.pop();   
            in.push(temp);
        }
        return target.intValue();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

class CQueue {          // �Ż�֮��Ľⷨ
    private Stack<Integer>in = new Stack<Integer>();    // ��ջ1
    private Stack<Integer>out = new Stack<Integer>();   // ��ջ2
    public CQueue() {
    }
    
    public void appendTail(int value) {     // ����Ҫ����ѹ��ջ
        in.push(new Integer(value));
    }
    
    public int deleteHead() {
        if(!out.empty()) return out.pop().intValue();       // out��ջ��Ϊ�գ���ôջ������FIFO
        else if(in.empty()) return -1;   // outջΪ����inΪ�գ�ֱ�ӷ���-1
        else{           // outջΪ�գ�in��������
            while(!in.empty()){         // inȫ����ջ���ŵ�out��
                Integer temp = in.pop();
                out.push(temp);
            }
        }
        return out.pop().intValue();
    }
}