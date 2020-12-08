class Solution {               // ������
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        int max_h = 3, max_m = 5;           // Сʱ��������������Ϊ3�����Ӳ�������������Ϊ5
        for(int i = 0; i <= num; i++){
            if(i > max_h) break;    // ���i>3����ô˵��h=4��Сʱ����Χ�ˡ��������Ѿ�����
            if(num - i > max_m)  continue;   // ���num-i>5����ô˵��m=6,���ӳ���Χ�ˡ�����Сʱ��Χ����
            for(int h = 0; h <= 11; h++){
                if(Integer.bitCount(h) == i){
                    for(int m = 0; m <= 59; m++){
                        if(Integer.bitCount(m) == num - i){
                            String temp = String.valueOf(h) + ":" + String.format("%02d", m);   // �����Ӳ���λ��
                            res.add(temp);
                        }
                    }
                }    
            }
        }
        return res;
    }
}