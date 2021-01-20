package DistanceBetweenBusStops_1184;


/**
 *环形公交路线上有n个站，按次序从0到n - 1进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i]表示编号为i的车站和编号为(i + 1) % n的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点start到目的地destination之间的最短距离。
 */
public class DistanceBetweenBusStops {

    public static void main(String[] args) {

        int[] distance={7,10,1,12,11,14,5,0};
        int start=7,destination=2;
        int result=new DistanceBetweenBusStops().distanceBetweenBusStops(distance,start,destination);
        System.out.println(result);

    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int startSum=0;
        int sum=0;
        if (start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }
        for (int i = start; i <destination; i++) {
            startSum+=distance[i];
        }
        for (int i : distance) {
            sum+=i;
        }

        return Math.min(startSum,sum-startSum);

    }
}
