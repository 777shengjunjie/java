package MinNumber_45;

import java.util.Arrays;

public class MinNumber {



    public static void main(String[] args) {

    }

    public String minNumber(int[] nums) {

        String[] str=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
        StringBuffer res=new StringBuffer();
        for (String s : str) {
            res.append(s);
        }

        return res.toString();

    }
}
