class Solution {
    public static int findMinArrowShots(int[][] points) {
        if(points == null) return 0;        // �ų��������
        else if(points.length == 1) return 1;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));    //���򡪡��������ʱ������
        int arrow = 0;  // ������������
        int i = 0;
        while(i < points.length){
            int range = points[i][1];   // �����endֵ
            arrow++;
            i++;
            for(; i < points.length; i++){
                if(points[i][0] > range) break;     // ����forѭ��
            }
        }
        return arrow;
    }
}

class Solution {            // ��΢�Ż��汾
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 1 || points.length == 0) return points.length;        // �ų��������

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));    //���򡪡��������ʱ������
        int arrow = 1;  // ������������
        int pre = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > pre){
                pre = points[i][1];
                arrow++;
            }
        }
        return arrow;
    }
}