class Solution {
    private void backtrace(List<String> res, String temp, int lleft, int lright){
        if(lleft == 0 && lright == 0) res.add(temp);
        if(lleft > lright) return;      // ������Ҫ���������õĶ࣬����ͼ�֦

        if(lleft > 0){
            backtrace(res, temp + "(", lleft - 1, lright);      // ÿ�δ��ݵĶ���һ���µ��ַ��������Բ���Ҫ����
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