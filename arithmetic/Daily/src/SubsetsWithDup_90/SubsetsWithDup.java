package SubsetsWithDup_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {


    public static void main(String[] args) {
        int[] ans={1,2,2};

        List<List<Integer>> lists = new SubsetsWithDup().subsetsWithDup(ans);
        System.out.println(lists);
    }

    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs(false,0,nums);

        return ans;
    }

//    public void backtracking(int[] nums,int startIndex,boolean[] used){
//        ans.add(list);
//        for (int i = startIndex; i < nums.length; i++) {
//            if (i>0&&nums[i]==nums[i-1]&& !used[i - 1]){
//                continue;
//            }
//            list.add(nums[i]);
//            used[i]=true;
//            backtracking(nums,i+1,used);
//            used[i]=false;
//            list.remove(nums[i]);
//        }
//    }


    private void dfs(Boolean choosePre,int cur,int[] nums) {
        if (cur==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(false,cur+1,nums);
        if (!choosePre&&cur>0&&nums[cur-1]==nums[cur]){
            return;
        }
        list.add(nums[cur]);
        dfs(true,cur+1,nums);
        list.remove(list.size()-1);

    }

}
