class Solution {
    public static int findMinArrowShots(int[][] points) {
        if(points == null) return 0;        // 排除特殊情况
        else if(points.length == 1) return 1;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));    //排序——最早结束时间优先
        int arrow = 0;  // 设置数量个数
        int i = 0;
        while(i < points.length){
            int range = points[i][1];   // 获得其end值
            arrow++;
            i++;
            for(; i < points.length; i++){
                if(points[i][0] > range) break;     // 跳出for循环
            }
        }
        return arrow;
    }
}

class Solution {            // 稍微优化版本
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 1 || points.length == 0) return points.length;        // 排除特殊情况

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));    //排序——最早结束时间优先
        int arrow = 1;  // 设置数量个数
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