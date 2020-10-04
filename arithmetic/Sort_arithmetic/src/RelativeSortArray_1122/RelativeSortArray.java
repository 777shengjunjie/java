package RelativeSortArray_1122;



/*

难度简单81给你两个数组，arr1 和 arr2，

        arr2 中的元素各不相同
        arr2 中的每个元素都出现在 arr1 中

        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
        未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

*/

import java.util.*;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        int[] result=new RelativeSortArray().relativeSortArray2(arr1,arr2);
        for (int i : result) {
            System.out.println(i);
        }



    }

    public int[] relativeSortArray(int[] arr1,int[] arr2){

        int index=0;
        int[] ans=new int[arr1.length];
        List<Integer> listAns=new ArrayList<>();
        List<Integer> listArray2=new ArrayList<>();
        Arrays.sort(arr1);
        List<Integer> list=new ArrayList<>();
        for (int i : arr2) {
            list.add(i);
        }


        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i : arr1) {
            int count=map.getOrDefault(i,0)+1;
            map.put(i,count);
        }
        
        while (!list.isEmpty()){
            int num=list.remove(0);
            int count=map.get(num);
            map.remove(num);
            while (count>0){
                listAns.add(num);
                count--;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            listArray2.add(entry.getKey());
        }

        listArray2.sort((o1, o2) -> o1-o2);
        for (Integer integer : listArray2) {
            int count=map.get(integer);
            while (count>0){
                listAns.add(integer);
                count--;
            }

        }
        for (Integer listAn : listAns) {
            ans[index++]=listAn;
        }

        return ans;

    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 将 arr1 中的数记录下来
        for (int num1 : arr1) {
            count[num1]++;
        }
        // 先安排 arr2 中的数
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        // 再排剩下的数
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }

}
