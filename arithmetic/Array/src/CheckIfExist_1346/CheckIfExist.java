package CheckIfExist_1346;


/**
 * 给你一个整数数组arr，请你检查是否存在两个整数N 和 M，满足N是M的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 */
public class CheckIfExist {

    public static void main(String[] args) {

        int[] arr={-2,0,10,-19,4,6,-8};
        boolean result=new CheckIfExist().checkIfExist(arr);
        System.out.println(result);
    }

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==2*arr[j]||arr[j]==2*arr[i])
                    return true;
            }
        }
        return false;
    }
}
