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
        for(int i = 1; i < prices.length; i++){         // �����������ǣ�����ʱ��������������������ֵ�Ƕ��٣����ǽ���ļ۸�-֮ǰ����ʷ��ͼ�
            minprice = minprice < prices[i-1] ? minprice : prices[i-1]; // ������ʷ���ֵ
            int temp = prices[i] - minprice;
            maxpro = maxpro > temp ? maxpro : temp;
        }
        return maxpro;
    }
}

class Solution {                // ��̬�滮�ķ���
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;             // �ų��߽�����
        int minprice = prices[0];
        int[]dp = new int[prices.length];           // ά��һ�����飬��ŵ�ǰ��ʱ��������ֵ
        dp[0] = 0;

        for(int i = 1; i < prices.length; i++){
            minprice = Math.min(prices[i], minprice);       // ��ǰ����ʷ���ֵ
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);  // ��ǰ���
        }
        return dp[prices.length - 1];
    }
}