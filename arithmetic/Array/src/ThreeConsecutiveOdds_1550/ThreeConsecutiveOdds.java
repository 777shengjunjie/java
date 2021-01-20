package ThreeConsecutiveOdds_1550;


/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
 * 如果存在，请返回 true ；否则，返回 false 。
 */
public class ThreeConsecutiveOdds {

    public static void main(String[] args) {

        int[] arr={1,2,34,3,4,5,7,23,12};
        boolean result=new ThreeConsecutiveOdds().threeConsecutiveOdds(arr);
        System.out.println(result);
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length<2) return false;
        int first=arr[0];
        int second=arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]%2==1&&second%2==1&&first%2==1){
                return true;
            }
            first=second;
            second=arr[i];
        }
        return false;
    }
}
