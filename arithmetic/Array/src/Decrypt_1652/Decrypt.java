package Decrypt_1652;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及
 * 一个密钥k。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 *
 * 如果k > 0，将第i个数字用 接下来k个数字之和替换。
 * 如果k < 0，将第i个数字用 之前k个数字之和替换。
 * 如果k == 0，将第i个数字用0替换。
 * 由于code是循环的，code[n-1]下一个元素是code[0],
 * 且code[0]前一个元素是code[n-1]。
 *
 * 给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 */
public class Decrypt {
    public static void main(String[] args) {

        int[] code={2,4,9,3};
        int k=-2;
        int[] result=new Decrypt().decrypt(code,k);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] decrypt(int[] code, int k) {
        int[] ans=new int[code.length];
        if (k==0) return ans;
        else if (k<0){

            for (int i = 0; i < code.length; i++) {
                int sum=0;
                int count=i+k;
                while (count<0){
                    sum+=code[code.length+count];
                    count++;
                }
                while (count<i){
                    sum+=code[count];
                    count++;
                }
                ans[i]=sum;
            }

            return ans;
        }else {

            int length=code.length;
            for (int i = 0; i < length; i++) {
                int sum=0;
                int count=i+k;
                while (count>=length){
                    sum+=code[count-length];
                    count--;
                }
                while (count>i){
                    sum+=code[count];
                    count--;
                }
                ans[i]=sum;
            }

            return ans;
        }
    }

    public int[] decrypt2(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];

        if (k == 0) {
            return result;
        } else {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = 0; j < Math.abs(k); j++) {
                    if (k > 0) {
                        sum += code[(i + j + 1) % length];
                    } else {
                        sum += code[(i - j - 1 + length) % length];
                    }
                }
                result[i] = sum;
            }
        }
        return result;
    }


}
