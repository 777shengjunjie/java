package Intersection_349;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*给定两个数组，编写一个函数来计算它们的交集。*/
public class Intersection {
    public static void main(String[] args) {


        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result=new Intersection().intersection(nums1,nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] intersection(int[] nums1,int[] nums2){

        int[] intersection=new int[nums1.length];
        int index=0;
        HashSet<Integer> set=new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                intersection[index++]=i;
                set.remove(i);
            }
        }

        return Arrays.copyOfRange(intersection,0,index);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        //set1中保留交集
        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }


}
