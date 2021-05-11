package ReverseLeftWords_58_2;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        StringBuffer sb=new StringBuffer();

        for (int i = n; i < s.toCharArray().length; i++) {
            sb.append(s.charAt(i));
        }
        for (int i=0;i<n;i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }



}
