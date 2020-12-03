class MyStack {
    private LinkedList<Integer> queue1 = new LinkedList<Integer>();     // 用两个队列实现的，实际上可以用一个队列实现
    private LinkedList<Integer> queue2 = new LinkedList<Integer>();
    private LinkedList<Integer> curQueue = queue1;
    /** Initialize your data structure here. */
    public MyStack() {
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.size() == 0 && queue2.size() == 0) curQueue = queue1;
        else if(queue1.size() == 0) curQueue = queue2;      // queue2不为空
        else curQueue = queue1;         // queue1不为空
        curQueue.addLast(x);    // 将元素插入队尾
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        LinkedList<Integer> disQueue;
        if(queue1.size() == 0) disQueue = queue1;      // queue1为空，为目标存储
        else disQueue = queue2;         // queue2为空，为目标存储
        int len = curQueue.size();
        for(int i = 0; i < len - 1; i++){
            int temp = curQueue.poll();
            disQueue.addLast(temp);
        }
        int res = curQueue.poll();
        curQueue = disQueue;
        return res;

    }
    
    /** Get the top element. */
    public int top() {
        LinkedList<Integer> disQueue;
        if(queue1.size() == 0) disQueue = queue1;      // queue1为空，为目标存储
        else disQueue = queue2;         // queue2为空，为目标存储
        int len = curQueue.size();
        for(int i = 0; i < len - 1; i++){
            int temp = curQueue.poll();
            disQueue.addLast(temp);
        }
        int res = curQueue.poll();
        disQueue.addLast(res);
        curQueue = disQueue;
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.size() == 0 && queue2.size() == 0) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */