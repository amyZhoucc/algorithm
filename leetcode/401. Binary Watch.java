class Solution {               // 暴力解
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        int max_h = 3, max_m = 5;           // 小时部分最多的亮灯数为3，分钟部分最多的亮灯数为5
        for(int i = 0; i <= num; i++){
            if(i > max_h) break;    // 如果i>3，那么说明h=4，小时超范围了——遍历已经结束
            if(num - i > max_m)  continue;   // 如果num-i>5，那么说明m=6,分钟超范围了——将小时范围扩大
            for(int h = 0; h <= 11; h++){
                if(Integer.bitCount(h) == i){
                    for(int m = 0; m <= 59; m++){
                        if(Integer.bitCount(m) == num - i){
                            String temp = String.valueOf(h) + ":" + String.format("%02d", m);   // 给分钟补齐位数
                            res.add(temp);
                        }
                    }
                }    
            }
        }
        return res;
    }
}