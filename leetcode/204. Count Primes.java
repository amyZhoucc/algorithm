class Solution {        // 暴力解超时
    private boolean isPrime(int n){
        if(n == 2) return true;
        for(int i = 2; i*i <= n; i++){          // 稍微的优化——sqrt(n)之后的数字一定不能将n整除
            if(n % i == 0) return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int num = 0;
        for(int i = 2; i < n; i++){         // 遍历从2开始的所有值，判断是否是质数：找从2~sqrt(n)的范围内看能不能整除
            if(isPrime(i)) num++;
        }
        return num;
    }
}

class Solution {            // 埃氏筛
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];  // 存放所有的数，默认全部为质数（true），后面会将实际的和数排除
        Arrays.fill(prime, true);           
        for(int i = 2; i * i < n; i++){         // 只需要从2~sqrt(n)即可，后面的数要么是前面的倍数要么就是质数
            if(prime[i]){
                for(int j = i * i; j < n; j += i){      // 从i*i开始即可，i之前的肯定被前面的数遍历过了
                    prime[j] = false;
                }
            }
        }
        int num = 0;
        for(int i = 2; i < n; i++){     // 最后将所有数都整理一下，输出其中的质数数
            if(prime[i]) num++;
        }
        return num;
    }
}