package KidsWithCandies_1431;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个数组candies和一个整数extraCandies，其中candies[i]代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的extraCandies个糖果分配给孩子们之后，此孩子有 最多的糖果。
 * 注意，允许有多个孩子同时拥有 最多的糖果数目。
 */
public class KidsWithCandies {

    public static void main(String[] args) {

        int[] candies={4,2,1,1,2};
        int extraCandies=1;
        List<Boolean> result=new KidsWithCandies().kidsWithCandies(candies,extraCandies);
        for (Boolean aBoolean : result) {
            System.out.println(aBoolean);
        }

    }


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> ans=new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            if (candy+extraCandies>=max){
                ans.add(true);
            }else {
                ans.add(false);
            }
        }

        return ans;
    }

    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;
    }


}
