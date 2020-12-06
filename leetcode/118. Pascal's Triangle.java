class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();      
        if(numRows == 0) return res;
        ArrayList<Integer> first = new ArrayList<Integer>();    //首行特殊处理
        first.add(1);   
        res.add(first);             // 记得要加入数组中        
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }
                else{
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}