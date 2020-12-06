package DecompressRLElist_1313;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个以行程长度编码压缩的整数列表nums。
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i],nums[2*i+1]]（其中i >= 0），
 * 每一对都表示解压后子列表中有 freq个值为val的元素，
 * 你需要从左到右连接所有子列表以生成解压后的列表。
 * 请你返回解压后的列表。
 */
public class DecompressRLElist {

    public static void main(String[] args) {
        int[] nums={1,1,2,3};
        int[] result=new DecompressRLElist().decompressRLElist(nums);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length/2; i++) {
            for (int j = 0; j < nums[2 * i]; j++) {
                ans.add(nums[2 * i + 1]);
            }
        }

        int[] num = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            num[i] = ans.get(i);
        }
        return num;
    }

}
