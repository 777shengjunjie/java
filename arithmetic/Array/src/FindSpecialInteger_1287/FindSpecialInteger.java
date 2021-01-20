package FindSpecialInteger_1287;


/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 */
public class FindSpecialInteger {

    public static void main(String[] args) {

        int[] arr={1,1,2,2,3,3,3,3,3};
        int result=new FindSpecialInteger().findSpecialInteger2(arr);
        System.out.println(result);
    }

    public int findSpecialInteger(int[] arr) {
        int length= arr.length%4==0?arr.length/4:arr.length/4+1;
        int count=1;
        int temp=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==temp){
                count++;
                if (count>length){
                    return arr[i];
                }
            }else {
                count=1;
                temp=arr[i];
            }
        }

        return arr[0];
    }

    public int findSpecialInteger2(int[] arr) {
        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i + threshold] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }

}
