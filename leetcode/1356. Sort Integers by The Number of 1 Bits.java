class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] += Integer.bitCount(arr[i]) * 100000;        // �����㷨����ĳ���Ķ����Ƶ�1������Ȼ���������������������ͬ1��������ֵ��һ��
        }
        Arrays.sort(arr);       // ����
        for(int i = 0; i < arr.length; i++){            // �ָ�ԭֵ
            arr[i] %= 100000;
        }
        return arr;
    }
}