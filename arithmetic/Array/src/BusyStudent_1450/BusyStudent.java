package BusyStudent_1450;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），
 * 并指定一个整数 queryTime 作为查询时间。
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。
 * 形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 */
public class BusyStudent {

    public static void main(String[] args) {
        int[] startTime={2,2,3,4};
        int[] endTime={6,4,4,5};
        int queryTime=4;
        int result=new BusyStudent().busyStudent2(startTime,endTime,queryTime);
        System.out.println(result);

    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        List<Integer> lists=new ArrayList<>();
        int count=0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i]<=queryTime){
                lists.add(i);
            }
        }
        for (Integer list : lists) {
            if (endTime[list]>=queryTime){
                count++;
            }
        }

        return count;

    }


    public int busyStudent2(int[] startTime, int[] endTime, int queryTime) {
        BIT bit = new BIT(1000);
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            bit.update(startTime[i], 1);
            bit.update(endTime[i] + 1, -1);
        }
        return bit.getPrefix(queryTime);
    }

    class BIT {
        int[] bit;
        int n;

        public BIT(int n) {
            this.n = n + 1;
            bit = new int[this.n];
        }

        public int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int val) {
            while (i < n) {
                bit[i] += val;
                i += lowBit(i);
            }
        }

        public int getPrefix(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= lowBit(i);
            }
            return sum;
        }
    }


}
