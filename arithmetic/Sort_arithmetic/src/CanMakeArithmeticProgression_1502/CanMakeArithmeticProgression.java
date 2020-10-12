package CanMakeArithmeticProgression_1502;


import java.util.Arrays;

/*
给你一个数字数组 arr 。

        如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。

        如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
*/
public class CanMakeArithmeticProgression {

    public static void main(String[] args) {

        int[] arr={4,2,1};
        boolean result=new CanMakeArithmeticProgression().canMakeArithmeticProgression(arr);
        System.out.println(result);
    }

    public boolean canMakeArithmeticProgression(int[] arr){

        Arrays.sort(arr);
        int temp=0;


        for (int i = 0; i < arr.length-1; i++) {

            int ans=arr[i+1]-arr[i];
            if (temp==0){
                temp=ans;
            }else if (temp!=ans){
                return false;
            }

        }

        return true;

    }

    public boolean canMakeArithmeticProgression2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
