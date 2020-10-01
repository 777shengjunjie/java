package Intersect_350;


/*
给定两个数组，编写一个函数来计算它们的交集。
*/

import java.util.*;

public class Intersect {

    public static void main(String[] args) {

        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result=new Intersect().intersect(nums1,nums2);
        for (int i : result) {
            System.out.println(i);
        }


    }

    public int[] intersect(int[] nums1,int[] nums2){

        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums1) {
            int count=map.getOrDefault(num,0)+1;
            map.put(num,count);
        }

        int[] intersect=new int[nums1.length];
        int index=0;


        for (int num : nums2) {
            int count=map.getOrDefault(num,0);
            if (count>0){
                intersect[index++]=num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }

        //原来的数组后续空间存在浪费的现象。
        return Arrays.copyOfRange(intersect,0,index);


    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


}
