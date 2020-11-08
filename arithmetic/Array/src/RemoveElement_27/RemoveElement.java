package RemoveElement_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，
 * 并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {


    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int val=3;
        int result=new RemoveElement().removeElement2(nums,val);
        System.out.println(result);
    }

    public int removeElement(int[] nums,int val){

        int ans=0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i]!=val){
              nums[ans]=nums[i];
              ans++;
            }

        }

        return ans;
    }

    public int removeElement2(int[] nums,int val){

        int n=nums.length;
        int i=0;
        while(i<n){

            if (nums[i]==val){
                nums[i]=nums[n-1];
                n--;
            }else {
                i++;
            }
        }

        return n;
    }

}
