package ToHex_405;


/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 */
public class ToHex {

    public static void main(String[] args) {

        int num=26;
        String result=new ToHex().toHex(num);
        System.out.println(result);

    }

    public String toHex(int num){
        if (num==0) return "0";
        StringBuilder sb=new StringBuilder();
        char[] arr="0123456789abcdef".toCharArray();
        while (num!=0){
            int temp=num&15;
            sb.append(arr[temp]);
            num>>>=4;
        }
        return sb.reverse().toString();
    }

    public String toHex3(int num){

        if (num==0) return "0";
        int[] bits=new int[32];
        for (int i = 31; i >= 0; i--) {
            bits[i]=num&1;
            num>>>=1;
        }


        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 32; ) {
            int result=0,index=0;
            while (index<4){
                result=bits[i]+2*result;
                i++;
                index++;
            }
            if (result<=9){
                sb.append(String.valueOf(result));
            }else{
                sb.append((char)(result-10+'a'));
            }
        }

        while (sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public String toHex2(int num) {
        if (num == 0) { return "0"; }   // 0特殊处理
        // 获取32位二进制位
        int[] bits = new int[32];
        for (int i = 31; i >= 0; i--) {
            bits[i] = num & 0x1;
            num >>>= 1;
        }
        // 从左到右每4位转成1位十六进制
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= 28; i += 4) {
            int sum = 8 * bits[i] + 4 * bits[i + 1] +
                    2 * bits[i + 2] + 1 * bits[i + 3];
            if (sum <= 9) {
                ans.append((char)(sum + '0'));
            } else if (sum <= 15) {
                ans.append((char)(sum - 10 + 'a'));
            }
        }
        // 去掉前导0，这就是为什么0要特殊处理的原因
        // 因为0的十六进制还是全为0，用这个循环会越界访问
        while (ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.toString();

    }

}
