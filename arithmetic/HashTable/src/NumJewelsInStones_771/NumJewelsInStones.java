package NumJewelsInStones_771;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。
 * S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J中的字母不重复，J和S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int result=new NumJewelsInStones().numJewelsInStones(jewels,stones);
        System.out.println(result);

    }

    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int sum = 0;
        for (char c : jewels.toCharArray()) {
            if (map.containsKey(c))
            sum += map.get(c);
        }

        return sum;
    }
}
