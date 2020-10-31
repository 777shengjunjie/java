package LongestWord_720;


import Util_Trie_LongestWord.Trie;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
 * 该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 */
public class LongestWord {


    public static void main(String[] args) {

        String[] words= {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String result=new LongestWord().longestWord(words);
        System.out.println(result);
    }

    /**
     * 前缀树 + 深度优先搜索
     * 将所有单词插入 trie，然后从 trie 进行深度优先搜索，每找到一个单词表示该单词的全部前缀均存在，我们选取长度最长的单词。
     * @param words
     * @return
     */
    public String longestWord(String[] words){

        Trie trie = new Trie();
        int index = 0;
        for (String word: words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();

    }

    /**
     * 暴力求解
     * @param words
     * @return
     */
    public String longestWord2(String[] words){

        String ans="";
        Set<String> wordsSet=new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        for (String word : words) {
            if (word.length()>ans.length()||word.length()==ans.length()&&word.compareTo(ans)<0){
                boolean flag=true;
                for (int i = 1; i < word.length(); i++) {
                    if (!wordsSet.contains(word.substring(0,i))){
                        flag=false;
                        break;
                    }
                }

                if (flag)   ans=word;
            }
        }

        return ans;
    }
}
