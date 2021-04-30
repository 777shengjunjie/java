package ReplaceSpace_05;

public class ReplaceSpace {


    public static void main(String[] args) {
        String s="We are happy";
        String result=new ReplaceSpace().replaceSpace(s);
        System.out.println(result);
    }

    public String replaceSpace(String s) {

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
