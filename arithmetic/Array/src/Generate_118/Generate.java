package Generate_118;


import javafx.scene.control.skin.SliderSkin;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Generate {


    public static void main(String[] args) {

        int numRows=5;
        List<List<Integer>> result=new Generate().generate(numRows);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

    public List<List<Integer>> generate(int numRows){

        List<List<Integer>> ans=new ArrayList<>();
        if (numRows==0) return ans;

        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row=new ArrayList<>();
            List<Integer> preRow=ans.get(rowNum-1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(preRow.get(j-1)+preRow.get(j));
            }

            row.add(1);
            ans.add(row);

        }

        return ans;
    }



}
