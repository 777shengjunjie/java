package ReadBinaryWatch_401;


import javafx.beans.property.ReadOnlyListProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，上面的二进制手表读取 “3:25”。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {

        int num=2;
        List<String> result=new ReadBinaryWatch().readBinaryWatch2(num);
        System.out.println(result);


    }


    public List<String> readBinaryWatch(int num){

        List<String> ans=new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if ((Integer.bitCount(h)+Integer.bitCount(m))==num){
                    ans.add(String.format("%d:%02d",h,m));
                }
            }

        }

        return ans;

    }


    private List<String> res = new LinkedList<>();
    public List<String> readBinaryWatch2(int num) {
        res.clear();
        dfs(num, 0, 0, 1, 1, new LinkedList<Integer>(), new LinkedList<Integer>());
        return res;
    }

    // h：小时数，m：分钟数
    // hstart、mstart：从hstart、mstart开始继续遍历小时和分钟
    // hours：选中的小时，minutes：选中的分钟
    private void dfs(int num, int h, int m, int hstart, int mstart, LinkedList<Integer> hours, LinkedList<Integer> minutes) {
        if (hours.size() + minutes.size() == num) {
            if (h < 12 && m < 60) res.add(String.format("%d:%02d", h, m));
            return;
        }
        for (int i = hstart; i <= 8; i <<= 1) {
            hours.addLast(i);
            dfs(num, h + i, m, i << 1, mstart, hours, minutes);
            hours.removeLast();
        }
        for (int i = mstart; i <= 32; i <<= 1) {
            minutes.addLast(i);
            dfs(num, h, m + i, 16, i << 1, hours, minutes); // hstart 直接设置为16（>=12)，避免重复计算
            minutes.removeLast();
        }
    }


}
