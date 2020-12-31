package AddToArrayForm_989;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。
 * 例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式A，返回整数X+K的数组形式。
 */
public class AddToArrayForm {

    public static void main(String[] args) {
        int[] A = {1, 2, 0, 0};
        int k = 34;
        List<Integer> result = new AddToArrayForm().addToArrayForm(A, k);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> ans = new ArrayList<>();
        int length = A.length;
        int cur = K;

        while (--length >= 0 || cur > 0) {
            if (length >= 0) {
                cur += A[length];
            }
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;

    }
}
