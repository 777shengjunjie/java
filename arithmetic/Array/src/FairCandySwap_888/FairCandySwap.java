package FairCandySwap_888;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，
 * B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，
 * 他们都有相同的糖果总量。
 * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
 * ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在
 */
public class FairCandySwap {

    public static void main(String[] args) {
        int[] A={1,2,5};
        int[] B={2,4};
        int[] result=new FairCandySwap().fairCandySwap(A,B);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] fairCandySwap(int[] A, int[] B) {

        int[] ans=new int[2];
        int SumA=0,SumB=0;
        for (int i : A) {
            SumA+=i;
        }
        for (int i : B) {
            SumB+=i;
        }
        int y=(SumB-SumA)/2;
        List<Integer> list=new ArrayList<>();
        for (int i : A) {
            list.add(i);
        }
        for (int j : B) {

            if (list.contains(j-y)){
                ans[0]=j-y;
                ans[1]=j;
                return ans;
            }
        }
        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }


}
