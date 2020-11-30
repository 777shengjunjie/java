package CanPlaceFlowers_605;


import java.util.ArrayList;
import java.util.List;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
 * 和一个数n。能否在不打破种植规则的情况下种入n朵花？能则返回True，不能则返回False。
 * 注意：
 * 1.数组内已种好的花不会违反种植规则。
 * 2.输入的数组长度范围为 [1, 20000]。
 * 3.n 是非负整数，且不会超过输入数组的大小。
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {

        int[] flowerbed={1,0,0,0,0,0,1};
        int n=2;
        boolean result=new CanPlaceFlowers().canPlaceFlowers(flowerbed,n);
        System.out.println(result);


    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int length=flowerbed.length;
        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) count.add(i);
        }
        if (count.size()==0) {
            if (length==1&&n==1) return true;
            return (length+1)/2>=n;
        }

        int sum=count.get(0)/2;
        for (int j = 1; j < count.size(); j++) {
            if(count.get(j-1)==0){
                sum+=(count.get(j)-count.get(j-1))/3;
                continue;
            }
            sum+=(count.get(j)-count.get(j-1)-1)/3;
        }

        sum+=(length-1-count.get(count.size()-1))/2;
        if (sum>=n){
            return true;
        }
        return false;
    }
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }




}
