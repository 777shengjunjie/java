package WordPattern_290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律

 */
public class WordPattern {

    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        String[] str=s.split(" ");
        Map map=new HashMap<>();

        if(pattern.length()!=str.length){
            return false;
        }
        for(Integer i=0;i<pattern.length();i++){
            if(!Objects.equals(map.put(pattern.charAt(i),i),(map.put(str[i],i)))){
                return false;
            }
        }

        return true;

    }
}
