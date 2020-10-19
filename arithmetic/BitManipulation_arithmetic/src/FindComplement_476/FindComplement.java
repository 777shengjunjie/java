package FindComplement_476;


/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 */
public class FindComplement {

    public static void main(String[] args) {

        int num = 5;
        int result = new FindComplement().findComplement(num);
        System.out.println(result);
    }

    public int findComplement(int num) {
        int ans=0,index=0;
        while (num!=0){

        ans+=((num&1)^1)<<index;
        num>>=1;
        index++;
        }

        return ans ;
    }

    public int findComplement2(int num) {
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);
    }


}
