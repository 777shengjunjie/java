package IsMonotonic_896;


/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 */
public class IsMonotonic {

    public static void main(String[] args) {

        int[] A={1,1,2};
        boolean result=new IsMonotonic().isMonotonic2(A);
        System.out.println(result);
    }

    public boolean isMonotonic(int[] A) {


        for (int i = 0; i < A.length-1; i++) {
            if (A[i]>=A[i+1]){
                if (i== A.length-2) return true;
                continue;
            }else {
                break;
            }
        }


        for (int i = 0; i < A.length-1; i++) {
            if (A[i]<=A[i+1]){
                continue;
            }else {
                return false;
            }
        }

        return true;
    }

    public boolean isMonotonic2(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }

}
