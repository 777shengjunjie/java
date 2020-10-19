package FindTheDifference_389;


/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母
 */
public class FindTheDifference {

    public static void main(String[] args) {

        String s="ae",t="aea";
        char result=new FindTheDifference().findTheDifference(s,t);
        System.out.println(result);

    }

    public char findTheDifference(String s,String t){

        int length=t.toCharArray().length-1;
        char ans=t.charAt(length);


        for (int i = 0; i < s.toCharArray().length; i++) {
            ans^=(s.charAt(i)^t.charAt(i));
        }

        return ans;
    }



}
