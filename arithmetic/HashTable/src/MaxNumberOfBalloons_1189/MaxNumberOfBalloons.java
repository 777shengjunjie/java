package MaxNumberOfBalloons_1189;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {

    public static void main(String[] args) {

    }

    public int maxNumberOfBalloons(String text) {
        int[] letters=new int[26];

        for(int i=0;i<text.length();i++){
            letters[text.charAt(i)-97]++;
        }

        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for(char ch : "balon".toCharArray()){
            if(letters[ch - 97] < min){
                min = letters[ch - 97];
            }
        }
        return min; }
}
