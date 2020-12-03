class Solution {        // �����ⳬʱ
    private boolean isPrime(int n){
        if(n == 2) return true;
        for(int i = 2; i*i <= n; i++){          // ��΢���Ż�����sqrt(n)֮�������һ�����ܽ�n����
            if(n % i == 0) return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int num = 0;
        for(int i = 2; i < n; i++){         // ������2��ʼ������ֵ���ж��Ƿ����������Ҵ�2~sqrt(n)�ķ�Χ�ڿ��ܲ�������
            if(isPrime(i)) num++;
        }
        return num;
    }
}

class Solution {            // ����ɸ
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];  // ������е�����Ĭ��ȫ��Ϊ������true��������Ὣʵ�ʵĺ����ų�
        Arrays.fill(prime, true);           
        for(int i = 2; i * i < n; i++){         // ֻ��Ҫ��2~sqrt(n)���ɣ��������Ҫô��ǰ��ı���Ҫô��������
            if(prime[i]){
                for(int j = i * i; j < n; j += i){      // ��i*i��ʼ���ɣ�i֮ǰ�Ŀ϶���ǰ�������������
                    prime[j] = false;
                }
            }
        }
        int num = 0;
        for(int i = 2; i < n; i++){     // ���������������һ�£�������е�������
            if(prime[i]) num++;
        }
        return num;
    }
}