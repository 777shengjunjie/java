package CanThreePartsEqualSum_1013;


/**
 * 给你一个整数数组A，只有可以将其划分为三个和相等的非空部分时才返回true，否则返回 false。
 * 形式上，如果可以找出索引i+1 < j且满足
 * A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]
 * 就可以将数组三等分。
 */
public class CanThreePartsEqualSum {


    public static void main(String[] args) {

        int[] A={3,3,6,5,-2,2,5,1,-9,4};
        boolean result=new CanThreePartsEqualSum().canThreePartsEqualSum(A);
        System.out.println(result);
    }

    public boolean canThreePartsEqualSum(int[] A){

        int sum=0;
        for (int i : A) {
            sum+=i;
        }


        int ave=0;
        int flag=0;
        for (int i = 0; i < A.length; i++) {
            ave+=A[i];
            if (ave!=(sum/3)){
                continue;
            }else {
                flag++;
                ave=0;
                if (flag==3){
                    return true;
                }
            }
        }

        return false;

    }

    public boolean canThreePartsEqualSum2(int[] A) {
        int s = 0;
        for (int num : A) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3;
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        while (j + 1 < n) {  // 需要满足最后一个数组非空
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }

}
