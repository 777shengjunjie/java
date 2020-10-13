package HammingDistance_461;


/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

        给出两个整数 x 和 y，计算它们之间的汉明距离。

        注意：
        0 ≤ x, y < 231.
*/
public class HammingDistance {

    public static void main(String[] args) {

        int x = 1, y = 4;
        int result = new HammingDistance().hammingDistance3(x, y);
        System.out.println(result);
    }

    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);

    }

    public int hammingDistance2(int x, int y) {

        int xor=x^y;
        int distance=0;
        while (xor!=0){

            /*
            if (xor%2==1){
                distance+=1;
            }
            */
            if ((xor&1)==1){
                distance+=1;
            }
           xor=xor>>1;
        }

        return distance;

    }
    //布赖恩·克尼根算法
    public int hammingDistance3(int x, int y) {

        int xor=x^y;

        int distance=0;
        while (xor!=0){
            xor&=(xor-1);
            distance+=1;
        }
        return distance;

    }

}
