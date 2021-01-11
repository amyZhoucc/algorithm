class Solution {
    private void backtrace(List<String> res, String temp, int lleft, int lright){
        if(lleft == 0 && lright == 0) res.add(temp);
        if(lleft > lright) return;      // 左括号要比右括号用的多，否则就剪枝

        if(lleft > 0){
            backtrace(res, temp + "(", lleft - 1, lright);      // 每次传递的都是一个新的字符串，所以不需要回溯
        }
        if(lright > 0){
            backtrace(res, temp + ")", lleft, lright - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrace(res, new String(), n, n);
        return res;
    }
}