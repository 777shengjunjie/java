package IsOneBitCharacter_717;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。
 * 第二种字符可以用两比特(10或11)来表示。
 * 现给一个由若干比特组成的字符串。
 * 问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        int[] bits={1,1,1,0};
        boolean result=new IsOneBitCharacter().isOneBitCharacter(bits);
        System.out.println(result);
    }

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]==1){
                i+=1;
                if (i==(bits.length-1)){
                    return false;
                }
            }

        }

        return true;
    }
    public boolean isOneBitCharacter2(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public boolean isOneBitCharacter3(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }



}
