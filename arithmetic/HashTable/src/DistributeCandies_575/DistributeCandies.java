package DistributeCandies_575;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 */
public class DistributeCandies {

    public static void main(String[] args) {

        int[] candyType={1,1,2,3};
        int result=new DistributeCandies().distributeCandies(candyType);
        System.out.println(result);
    }
    public int distributeCandies(int[] candyType) {
        Set set=new HashSet();
        for(int num:candyType){
            set.add(num);
        }
        int length=set.size();
        if (length>candyType.length/2){
            return candyType.length/2;
        }else{
            return length;
        }


    }
}
