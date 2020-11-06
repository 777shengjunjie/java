package CheckStraightLine_1232;


/**
 * 在一个XY 坐标系中有一些点，我们用数组coordinates来分别记录它们的坐标，
 * 其中coordinates[i] = [x, y]表示横坐标为 x、纵坐标为 y的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class CheckStraightLine {

    public static void main(String[] args) {


        int[][] coordinates={{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        boolean result=new CheckStraightLine().checkStraightLine(coordinates);
        System.out.println(result);

    }

    public boolean checkStraightLine(int[][] coordinates){

        if (coordinates.length==2) return true;

        boolean flag=false;

        for (int i = 0; i < coordinates.length; i++) {

            if (i==coordinates.length-2) break;
            int preSubX=coordinates[i][0]-coordinates[i+1][0];
            int preSubY=coordinates[i][1]-coordinates[i+1][1];

            int aftSubX=coordinates[i+1][0]-coordinates[i+2][0];
            int aftSubY=coordinates[i+1][1]-coordinates[i+2][1];

            if (aftSubX==0&&preSubX==0) {
                flag=true;
                continue;
            }

            if (((double)preSubY/(double) preSubX)==((double) aftSubY/(double) aftSubX)) {
                flag=true;
            } else {
                flag=false;
                break;
            }

        }

        return flag;
    }

    public boolean checkStraightLine2(int[][] coordinates) {
        int x1 =coordinates[1][0]-coordinates[0][0];
        int y1 =coordinates[1][1]-coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x2 =coordinates[i][0]-coordinates[0][0];
            int y2 =coordinates[i][1]-coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }

}
