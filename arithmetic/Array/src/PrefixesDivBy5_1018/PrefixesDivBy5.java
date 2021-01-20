package PrefixesDivBy5_1018;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定由若干0和1组成的数组 A。我们定义N_i：从A[0] 到A[i]的第 i个子数组被解释为一个二进制数
 * （从最高有效位到最低有效位）。
 * 返回布尔值列表answer，只有当N_i可以被 5整除时，答案answer[i] 为true，否则为 false
 */
public class PrefixesDivBy5 {

    public static void main(String[] args) {

        int[] A={1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        List<Boolean> result=new PrefixesDivBy5().prefixesDivBy5(A);
        for (Boolean aBoolean : result) {
            System.out.println(aBoolean);
        }

    }


    public List<Boolean> prefixesDivBy5(int[] A) {


        List<Boolean> ans=new ArrayList<>();
        int b=0;
        for (int i : A) {
            b=(b*2+i)%5;
            ans.add(b==0);
        }

        return ans;

    }
}
