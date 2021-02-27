package FindRestaurant_599;

import java.util.*;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，
 * 并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。
 * 你可以假设总是存在一个答案。
 *
 */
public class FindRestaurant {

    public static void main(String[] args) {

        String[] list1={"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2={"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result=new FindRestaurant().findRestaurant(list1,list2);
        for (String s : result) {
            System.out.println(s);
        }
    }


    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap< Integer, List < String >> map = new HashMap < > ();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList < String > ());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);

     }
}
