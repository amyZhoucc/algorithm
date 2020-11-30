class CQueue {          // 我的解法——笨蛋解法
    private Stack<Integer>in = new Stack<Integer>();    // 堆栈1
    private Stack<Integer>out = new Stack<Integer>();   // 堆栈2
    public CQueue() {
    }
    
    public void appendTail(int value) {     // 把需要的数压入栈
        in.push(new Integer(value));
    }
    
    public int deleteHead() {
        if(in.empty()) return -1;   // 栈为空，直接返回-1
        while(!in.empty()){         // in全部出栈，放到out中
            Integer temp = in.pop();
            out.push(temp);
        }
        Integer target = out.pop();     // 将out的栈顶（就是in的栈底），就是队首
        while(!out.empty()){        // out全部出栈，放回到in中
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

class CQueue {          // 优化之后的解法
    private Stack<Integer>in = new Stack<Integer>();    // 堆栈1
    private Stack<Integer>out = new Stack<Integer>();   // 堆栈2
    public CQueue() {
    }
    
    public void appendTail(int value) {     // 把需要的数压入栈
        in.push(new Integer(value));
    }
    
    public int deleteHead() {
        if(!out.empty()) return out.pop().intValue();       // out的栈不为空，那么栈顶就是FIFO
        else if(in.empty()) return -1;   // out栈为空且in为空，直接返回-1
        else{           // out栈为空，in还有数据
            while(!in.empty()){         // in全部出栈，放到out中
                Integer temp = in.pop();
                out.push(temp);
            }
        }
        return out.pop().intValue();
    }
}