package CountCharacters_1160;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组）words和一张『字母表』（字符串）chars。
 * 假如你可以用chars中的『字母』（字符）拼写出 words中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表words中你掌握的所有单词的 长度之和。
 */
public class CountCharacters {

    public static void main(String[] args) {

        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        int result = new CountCharacters().countCharacters(words, chars);
        System.out.println(result);


    }

    public int countCharacters(String[] words, String chars) {
        int length = 0;
        for (String word : words) {
            length += helper(word, chars);
        }

        return length;


    }

    private int helper(String word, String chars) {
        int length=0;
        Map<Character, Integer> mc = new HashMap();
        for (char c : chars.toCharArray()) {
            int num = mc.getOrDefault(c, 0);
            mc.put(c, num + 1);
        }
        int l = word.length();
        for (char c : word.toCharArray()) {
            if (mc.containsKey(c) && mc.get(c) > 0) {
                mc.put(c, mc.get(c) - 1);
                l--;
                if (l == 0) {
                    length = word.length();
                }
            } else {

                break;
            }
        }
        return length;
    }

    public int countCharacters2(String[] words, String chars) {
        Map<Character, Integer> charsCnt = new HashMap<Character, Integer>();
        int length = chars.length();
        for (int i = 0; i < length; ++i) {
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCnt = new HashMap<Character, Integer>();
            int wordLength = word.length();
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += word.length();
            }
        }
        return ans;
    }


}
