package FindNumbers_1295;


/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class FindNumbers {


    public static void main(String[] args) {
        int[] nums={12,345,2,6,7896};
        int result=new FindNumbers().findNumbers(nums);
        System.out.println(result);
    }

    public int findNumbers(int[] nums){
        int ans=0;
        for (int num : nums) {
            boolean flag=helper(num);
            if (flag){
                ans++;
            }
        }

        return ans;
    }

    private boolean helper(int num) {

        int index=0;
        while (num!=0){
            index++;
            num/=10;
        }
        return index%2==0;
    }

    public int findNumbers2(int[] nums) {
        int res = 0;
        for(int i:nums){
            if(String.valueOf(i).length() % 2 == 0) res++;
        }
        return res;
    }




}
