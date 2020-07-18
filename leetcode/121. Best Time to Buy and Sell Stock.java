class Solution {			// �����ⷨ
    public int maxProfit(int[] prices) {
        int maxpro = 0; // ����������
        for(int i = 0; i < prices.length - 1; i++){        // �����Ʊ������
            for(int j = i + 1; j < prices.length; j++){    // ����������Ʊ������
                int temp =  prices[j] -  prices[i];
                maxpro = maxpro > temp ? maxpro : temp;
            }
        }
        return maxpro;
    }
}

class Solution {		// һ�α����ķ���
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxpro = 0;     // ��¼�������
        int minprice = prices[0];   // �����ʷ���ֵ
        for(int i = 1; i < prices.length; i++){         // ����ʱ��
            minprice = minprice < prices[i-1] ? minprice : prices[i-1]; // ������ʷ���ֵ
            int temp = prices[i] - minprice;
            maxpro = maxpro > temp ? maxpro : temp;
        }
        return maxpro;
    }
}