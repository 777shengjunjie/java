package PlusOne_66;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {


    public static void main(String[] args) {

        int[] digits={9};
        int[] result=new PlusOne().plusOne(digits);
        for (int i : result) {
            System.out.println(i);
        }

    }
    public int[] plusOne(int[] digits){

        List<Integer> array=new ArrayList<>();
        for (int digit : digits) {
            array.add(digit);
        }
        return helper(array).stream().mapToInt(Integer::intValue).toArray();

    }

    private List<Integer> helper(List<Integer> array) {
        if (array.size()==0)  {
            array.add(1);
            return array;
        }
        int last=array.size()-1;
        if (array.get(last)==9){
            array.remove(last);
            array=helper(array);
            array.add(0);
        }else{
            array.set(last,array.get(last)+1);
        }
        return array;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }




}
