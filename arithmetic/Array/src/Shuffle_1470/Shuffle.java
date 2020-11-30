package Shuffle_1470;


/**
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,4,3,2,1};
        int n=4;
        int[] result=new Shuffle().shuffle(nums,n);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];
        int index=0;
        for (int i = 0; i < n;i++) {
            ans[index] = nums[i];
            ans[index + 1] = nums[i + n];
            index+=2;
        }
        return ans;

    }
    public int[] shuffle3(int[] nums, int n) {
        int [] ret = new int[2*n];
        for(int i=0;i<n;i++){
            ret[i*2]=nums[i];
            ret[i*2+1]= nums[n+i];
        }
        return ret;

    }



}
