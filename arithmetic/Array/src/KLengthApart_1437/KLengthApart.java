package KLengthApart_1437;


/**
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
 * 如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 */
public class KLengthApart {

    public static void main(String[] args) {
        int[] nums={0,1,0,1};
        int k=1;
        boolean result=new KLengthApart().kLengthApart(nums,k);
        System.out.println(result);
    }

    public boolean kLengthApart(int[] nums, int k) {
        int preIndex=0;
        if (nums[0]==0){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==1){
                    if (i<k){
                        return false;
                    }else {
                        preIndex=i;
                        break;
                    }

                }
            }
        }

        for (int i = preIndex+1; i < nums.length; i++) {
            if (nums[i]==1){
                if (i-preIndex-1<k){
                    return false;
                }
                preIndex=i;
            }
        }
        return true;
    }


    public boolean kLengthApart2(int[] nums, int k) {
        int n = nums.length;
        int prev = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }


}
