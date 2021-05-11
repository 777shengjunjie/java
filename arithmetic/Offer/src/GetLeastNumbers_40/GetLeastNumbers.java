package GetLeastNumbers_40;

import java.util.Arrays;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);
        int[] res=new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i]=arr[i];
        }
        return res;
    }

}
