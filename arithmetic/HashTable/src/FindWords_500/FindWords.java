package FindWords_500;

import java.util.*;

public class FindWords {

    public static void main(String[] args) {
    String[] words={"Hello","Alaska","Dad","Peace"};
    String[] result=new FindWords().findWords(words);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String[] findWords(String[] words) {
        List<String> list=new ArrayList();
        Map<Character,Integer> map=new HashMap();
        String[] lines={
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        for (int i = 0; i < lines.length; i++) {
            for(char c:lines[i].toCharArray()){
                map.put(c,i+1);
            }

        }
        for (String word : words) {

            int line=map.get(word.toLowerCase().toCharArray()[0]);
            for(int i=0;i<word.toCharArray().length;i++){
                int currLines= map.get(word.toLowerCase().toCharArray()[i]);
                if(currLines!=line){
                    break;
                }
                if(i==word.toCharArray().length-1){
                    list.add(word);
                }
            }
        }
        return list.toArray(new String[list.size()]);

    }
}
