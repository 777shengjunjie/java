package MinArray_11;

public class MinArray {


    public static void main(String[] args) {
        int[] numbers={1,3,5};
        int res=new MinArray().minArray2(numbers);
        System.out.println(res);
    }

    public int minArray(int[] numbers) {
        if(numbers.length==1) return numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {

        int i=0,j=numbers.length-1;
        while (i<j){
            int m=(i+j)/2;
            if (numbers[m]<numbers[j]){
                j=m;
            }else if(numbers[m]>numbers[j]){
                i=m+1;
            }else {
                j--;
            }
        }
        return numbers[i];

    }


}
