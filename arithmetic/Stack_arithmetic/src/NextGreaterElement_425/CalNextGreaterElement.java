package NextGreaterElement_425;





/*

给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。

 nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CalNextGreaterElement {


    public static void main(String[] args) {

        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        int[] result=new CalNextGreaterElement().nextGreaterElement(nums1,nums2);
        for (int i : result) {
            System.out.println(i);
        }

    }



    public int[] nextGreaterElement(int[] nums1,int[] nums2){

        int[] ans=new int[nums1.length];
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {


            while (!stack.isEmpty()&&nums2[i]>stack.peek()) {
                map.put(stack.pop(),nums2[i]);


            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i=0 ;i< nums1.length;i++) {
            ans[i]=map.get(nums1[i]);
        }

        return ans;


    }


}
