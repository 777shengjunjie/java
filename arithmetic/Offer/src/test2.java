import java.util.Arrays;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int[] scores=new int[n];
        for (int i = 0; i < n; i++) {
            scores[i]=sc.nextInt();
        }
        int result=new test2().get(n,x,y,scores);
        System.out.println(result);
    }

    public int get(int n,int x,int y,int[] scores){


        Arrays.sort(scores);

        int notPass=n-y;
        if (notPass>y){
            return -1;
        }else if (notPass>=x&&notPass<=y){
            return scores[n-y-1];
        }else {
            return scores[x-1];
        }
    }

//    import java.util.Arrays;
//import java.util.Scanner;
//
//    /**
//     * 美团校招 第10场 第1题
//     */
//    public class Main {
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int n = in.nextInt();
//            int x = in.nextInt();
//            int y = in.nextInt();
//            int[] score = new int[n];
//            for (int i = 0; i < n; i++) {
//                score[i] = in.nextInt();
//            }
//            /**
//             * 符合条件的最低分数线 -> 过线的人多 -> 使用人数限制最大值 y作为过线人数 -> 判断剩下的人数 是否在[x,y]区间 ->
//             *      如果在 直接返回
//             *      如果不在
//             *          如果人数少于x 则直接找到分数最低的第x个人即可
//             *          如果人数大于y 则证明找不到一个分数线满足条件
//             */
//            // 对成绩排序
//            Arrays.sort(score);
//            // 没过线的人数
//            int notOk = n - y;
//            if (notOk > y){
//                System.out.println(-1);
//            }else if (notOk >= x && notOk <= y){
//                System.out.println(score[n-y-1]);
//            }else{
//                System.out.println(score[x-1]);
//            }
//        }
//    }

}
