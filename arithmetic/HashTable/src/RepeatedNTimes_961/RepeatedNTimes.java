package RepeatedNTimes_961;

import java.util.Arrays;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 */
public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int length=A.length/2;
        if(A[length-2]==A[length-1]){
            return A[length-1];
        }else{
            return A[length];
        }
    }
}
