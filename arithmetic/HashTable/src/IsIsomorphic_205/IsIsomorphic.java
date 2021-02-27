package IsIsomorphic_205;

import java.util.*;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，
 * 字符可以映射到自己本身。
 */
public class IsIsomorphic {

    public static void main(String[] args) {
    String s="add",t="egg";
    boolean result=new IsIsomorphic().isIsomorphic(s,t);
        System.out.println(result);
    }

    public boolean isIsomorphic(String s, String t) {
        Map map=new HashMap<>();
        Set set=new HashSet<>();
        if  (s.length()!=t.length()) return false;
        int length=s.length();
        for(int i=0;i<length;i++){
            if (map.containsKey(s.charAt(i))){
                if(!Objects.equals(map.get(s.charAt(i)),t.charAt(i))){
                    return false;
                }else{
                    continue;
                }

            }else{
                if(set.contains(t.charAt(i))){
                    return false;
                }
                set.add(t.charAt(i));
                map.put(s.charAt(i),t.charAt(i));
            }

        }

        return true;
    }
}
