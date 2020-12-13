package CreateTargetArray_1389;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 *
 * 题目保证数字插入位置总是存在。
 */
public class CreateTargetArray {

    public static void main(String[] args) {
        int[] nums={0,1,2,3,4};
        int[] index={0,1,2,2,1};
        int[] result=new CreateTargetArray().createTargetArray(nums,index);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] ans=new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
