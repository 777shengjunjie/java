package MaxSubArray_53;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    /**
     * 对于一个区间 [l, r][l,r]，我们可以维护四个量：
     * lSum 表示 [l, r][l,r] 内以 ll 为左端点的最大子段和
     * rSum 表示 [l, r][l,r] 内以 rr 为右端点的最大子段和
     * mSum 表示 [l, r][l,r] 内的最大子段和
     * iSum 表示 [l, r][l,r] 的区间和
     */
    private int lSum,rSum,mSum,iSum=0;

    public MaxSubArray(int lSum, int rSum, int mSum, int iSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.mSum = mSum;
        this.iSum = iSum;
    }

    public MaxSubArray() {
    }

    public static void main(String[] args) {

        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int result=new MaxSubArray().maxSubArray3(nums);
        System.out.println(result);
    }

    /**
     * 用 f(i)f(i) 代表以第 ii 个数结尾的「连续子数组的最大和」,
     * f(i)=max{f(i−1)+ai,ai}
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){

        int[] fx=new int[nums.length];
        int max=nums[0];
        fx[0]=max;
        for (int i = 1; i < nums.length; i++) {
            fx[i]=Math.max(fx[i-1]+nums[i],nums[i]);
            if (fx[i]>max){
                max=fx[i];
            }
        }
        return max;
    }

    /**
     * 方法一的优化
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }




    /**
     * 线段树
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {

        return getInfo(nums,0,nums.length-1).mSum;
    }

    public MaxSubArray getInfo(int[] a,int l,int r){
        if (l==r) return new MaxSubArray(a[l],a[l],a[l],a[l]);
        int m=(l+r)>>1;
        MaxSubArray lSub=getInfo(a,l,m);
        MaxSubArray rSub=getInfo(a,m+1,r);
        return pushUp(lSub,rSub);

    }

    private MaxSubArray pushUp(MaxSubArray lSub, MaxSubArray rSub) {
        //区间和
        int iSum=lSub.iSum+rSub.iSum;
        //左区间最大和
        int lSum=Math.max(lSub.iSum+rSub.lSum,lSub.lSum);
        //右区间最大和
        int rSum=Math.max(lSub.rSum+rSub.iSum,rSub.rSum);
        //区间最大子段和
        int mSum=Math.max(Math.max(lSub.mSum,rSub.mSum),lSub.rSum+rSub.lSum);
        return new MaxSubArray(lSum,rSum,mSum,iSum);



    }


}
