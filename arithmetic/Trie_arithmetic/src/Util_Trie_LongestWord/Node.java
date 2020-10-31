package Util_Trie_LongestWord;

import java.util.HashMap;

public class Node {

    public char c;
    public HashMap<Character,Node> children=new HashMap<>();
    public int end;
    public Node(char c) {
        this.c=c;
    }
}
