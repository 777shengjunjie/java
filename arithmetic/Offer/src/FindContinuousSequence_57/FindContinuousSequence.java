package FindContinuousSequence_57;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {


    public static void main(String[] args) {
        int[][] result=new FindContinuousSequence().findContinuousSequence(9);
        for (int[] ints : result) {
            System.out.println(ints);
        }
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        if (target < 3) {
            return new int[0][0];
        }

        int end = target / 2 + 1;
        int sum = 0;
        for (int i = 1; i <= end; i++) {

            for (int k=i;;k++){
                sum += k;
                if (sum>target){
                    sum=0;
                    break;
                }
                if (sum == target) {
                    int[] count = new int[k - i + 1];
                    for (int j = i,l=0; j <= k; j++,l++) {
                        count[l] = j;
                    }
                    ans.add(count);
                    sum=0;
                    break;
                }
            }

        }
        return ans.toArray(new int[ans.size()][]);

    }
}
