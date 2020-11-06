package MinTimeToVisitAllPoints_1266;



/**
 * 平面上有n个点，点的位置用整数坐标表示points[i] = [xi, yi]。
 * 请你计算访问所有这些点需要的最小时间（以秒为单位）。
 * 你可以按照下面的规则在平面上移动：
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 */
public class MinTimeToVisitAllPoints {

    public static void main(String[] args) {



        int[][] points={{1,1},{3,4},{-1,0}};
        int result=new MinTimeToVisitAllPoints().minTimeToVisitAllPoints(points);
        System.out.println(result);
    }


    public int minTimeToVisitAllPoints(int[][] points){

        int sum=0;

        for (int i = 0; i < points.length; i++) {

            if (i==points.length-1) break;
            int pre=Math.abs(points[i][0]-points[i+1][0]);
            int aft=Math.abs(points[i][1]-points[i+1][1]);

            sum+=Math.max(pre,aft);

        }

        return sum;
    }


}
