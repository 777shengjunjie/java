package NumberOfSteps_1342;




/**
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class NumberOfSteps {

    public static void main(String[] args) {

        int num=14;
        int result =new NumberOfSteps().numberOfSteps2(num);
        System.out.println(result);
    }

    public int numberOfSteps(int num){

        int count=0;

        while (num!=0){

            if (num%2==0){
                num/=2;
                count++;
            }else {
                num-=1;
                count++;
            }

        }

        return count;

    }

    public int numberOfSteps2(int num){

        int count = 0;
        while (num != 0) {
            count++;
            //num & -2
            num = (num & 1) == 1 ? num - 1 : num >> 1;
        }
        return count;


    }
}
