package ReversePairs_51;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.List;

public class ReversePairs {

    public static void main(String[] args) {

    }


    int[] nums,temp;
    public int reversePairs(int[] nums) {
        this.nums=nums;
        temp=new int[nums.length];
        return mergeSort(0,nums.length-1);
    }

    private int mergeSort(int l, int r) {
        if (l>=r) return 0;
        int m=(l+r)/2;
        int res=mergeSort(l,m)+mergeSort(m+1,r);
        int i=l,j=m+1;
        for (int k=l;k<=r;k++){
            temp[k]=nums[k];
        }
        for (int k=l;k<=r;k++){
           if (i==m+1) nums[k]=temp[j++];
           else if (j==r+1||temp[i]<=temp[j]) nums[k]=temp[i++];
           else {
               nums[k]=temp[j++];
               res+=m-i+1;
           }
        }
        return res;
    }


    //暴力求解，超时
    int count=0;
    public int reversePairs2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            help(nums,i);
        }
      return count;
    }

    private void help(int[] nums, int i) {

        for (int j = i+1; j < nums.length; j++) {
            if (nums[i]>nums[j]){
                count++;
            }
        }
    }


}
