package leetcode_algorithm;

 class Solution {
	    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        int len = candies.length;   // �����鳤��
	        int maxCandies = 0;     // �������ǹ�����δ�������ǹ�ʱ��

	        for(int i = 0; i < len; i++){           //  ������ǹ���
	            // if (maxCandies <= candies[i]) 
	            //     maxCandies = candies[i];
	            maxCandies = Math.max(maxCandies, candies[i])   // ���ú��� Math.max ��
	        }

	        List<Boolean> ret = new ArrayList<Boolean>();    // �½�һ���������
	        for(int i = 0; i < len; i++){                   // �������жϼ���extra�Ƿ��ܴﵽ���
	            if (candies[i] + extraCandies >= maxCandies)
	                ret.add(true);                          // ��������
	            else
	                ret.add(false);                 
	        }
	        return ret;
	    }
	}