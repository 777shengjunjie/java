package ReplaceElements_1299;

import java.util.Arrays;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 */
public class ReplaceElements {

    public static void main(String[] args) {

        int[] arr={17,18,5,4,6,1};
        int[] result=new ReplaceElements().replaceElements(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                arr[i]=-1;
            }else{
                arr[i]=getMax(arr,i);
            }
        }
        return arr;
    }

    public int getMax(int[] arr,int i){
        int ans=Integer.MIN_VALUE;
        for (int j=i+1; j < arr.length; j++) {
            ans=Math.max(ans,arr[j]);
        }
        return ans;
    }

    public int[] replaceElements2(int[] arr) {

        int n=arr.length;
        int[] ans=new int[n];
        ans[n-1]=-1;
        for (int i=n-2;i>=0;i--){
            ans[i]=Math.max(ans[i+1],arr[i+1]);
        }
        return ans;
    }
}
