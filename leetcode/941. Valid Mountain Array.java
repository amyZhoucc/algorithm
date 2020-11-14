class Solution {                // �ⷨ1
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) return false;       // �����������  
        if(arr[1] <= arr[0]) return false;      // ��ʼ�Ϳ�ʼ���µģ��Ͳ�����Ҫ��

        boolean flag = true;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(flag && prev < arr[i]){      // ��Ȼ������
                flag = true;
            }
            else if(flag && prev > arr[i]){     // ǰ�����ߵ�ǰ��ʼ������
                flag = false;
            }
            else if(!flag && prev > arr[i]){    // ǰ�潵�ͣ��������������
                flag = false;
            }
            else{               // ���������Ϊ��
                return false;
            }
            prev = arr[i];
        }
        if(flag == true) return false;      // һֱû�н��͹�
        return true;
    }
}

class Solution {            // �ⷨ2
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) return false;
        int high = 0;
        int i = 1;
        while(i < arr.length && arr[i - 1] < arr[i]){         // ����������λ��
            i++;
        }
        high = i - 1;           
        if(high == 0 || high == arr.length-1) return false; // �ж϶����ǲ��ǳ����ڿ�ͷ���ǽ�β����������Ҫ��
        while(i < arr.length){                  // ��������
            if(arr[i - 1] <= arr[i]) return false;      // �����ƽ��/���¾�ֱ��false
            i++;
        }
        return true;
    }
}