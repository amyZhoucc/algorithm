class Solution {            // ����ָ�뷨
    private int count(int n){       // ������һ����
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int one = n, two = count(n);
        while(two != 1 && one != two){
            one = count(one);       // ��ָ��һ����һ��
            two = count(two);       // ��ָ��һ��������
            two = count(two);
        }
        if(two == 1) return true;       // �����˥����1�ˣ���ô���ǿ�����
        else return false;          // �������Ϊ���������ģ���ô������Ϊ������ѭ��
    }
}

class Solution {            // ��ϣ���Ϸ�
    private int count(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> store = new HashSet<Integer>();        // ��һ��hash���ϴ�ų��ֹ������֣�����������
        while(n != 1){
            n = count(n);
            if(!store.contains(n)) store.add(n);        // ��������������֣��ͼ��뼯���У����ҵ�ʱ�临�Ӷ�ΪO(1)
            else return false;          // ������ֹ�����˵������ѭ������ֱ�ӷ���
        }
        return true;
    }
}