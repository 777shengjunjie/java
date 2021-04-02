package Permute_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    public static void main(String[] args) {

        String s="1,2,3";
        String[] split = s.split(",");
        System.out.println(split[0]);
        String s2=s.substring(1,2);

        List list=new ArrayList();
        for (Object o : list) {
            System.out.println(o);
        }
//        int i=2,j=5,k=100;
//        float s=(float) k/(i+j);

        int[] nums={1,2,3};
        List<List<Integer>> result=new Permute().permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


}
