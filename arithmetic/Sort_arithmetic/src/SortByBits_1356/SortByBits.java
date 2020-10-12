package SortByBits_1356;


import java.util.Arrays;

/*
给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。

        如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。

        请你返回排序后的数组。
*/
public class SortByBits {

    public static void main(String[] args) {

        int[] arr={0,1,2,3,4,5,6,7,8};
        int[] result=new SortByBits().sortByBits(arr);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] sortByBits(int[] arr){

        int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i]=countBits2(arr[i])*100000+arr[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            ans[i]=ans[i]%100000;
        }

        return ans;
    }



    public int countBits2(int num){
        int count=0;
        while (num!=0){
            count++;
            num=num & (num-1);
        }
        return count;

    }

    public int countBits3(int num) {
        return Integer.bitCount(num);
    }

}
