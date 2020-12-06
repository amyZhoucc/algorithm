class Solution {           // �ҵĽⷨ
    int[] prime = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};    // prime��������������������10^6��Χ�ڣ����Զ�Ӧ��λ��������19λ�����Ծ�дǰ19�������е����������
    private boolean isPrime(int n){         // ʵ����һ����n��bitλ����Ȼ�������λ���Ƿ���һ������ֵ
        int bit = 0;
        while(n != 0){
            if(n % 2 == 1) bit++;
            n >>= 1;
        }
        return prime[bit] == 1;
    }
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++){
            if(isPrime(i)) count++;
        }
        return count;
    }
}

class Solution {            // �Ż��ⷨ
    int[] prime = new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};    
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++){
            count += prime[Integer.bitCount(i)];        // ֱ�ӵ��ÿ⺯��
        }
        return count;
    }
}