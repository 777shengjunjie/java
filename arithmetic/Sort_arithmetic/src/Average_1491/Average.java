package Average_1491;


import java.util.Arrays;

/*
难度简单12给你一个整数数组 salary ，数组里每个数都是 唯一 的，
        其中 salary[i] 是第 i 个员工的工资。

        请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
*/
public class Average {

    public static void main(String[] args) {

        int[] salary={4000,3000,1000,2000};
        double result=new Average().average(salary);
        System.out.println(result);
    }

    public double average(int[] salary){

        Arrays.sort(salary);
        int len=salary.length;
        double ans=0;
        for (int i = 1; i < len-1; i++) {
            ans+=salary[i];
        }
        ans/=(len-2);
        return ans;
    }
    public double average2(int[] salary) {
        double sum = 0;
        double maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int num : salary) {
            sum += num;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }
        return (sum - maxValue - minValue) / (salary.length - 2);
    }

}
