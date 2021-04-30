package ReverseWords_58_1;

public class ReverseWords {


    public static void main(String[] args) {
        String s="a good   example";
        String result=new ReverseWords().reverseWords(s);
        System.out.println(result);
    }

    public String reverseWords(String s) {

        StringBuilder sb=new StringBuilder();
        String[] words = s.split("\\s");
        for (int i = words.length-1; i >= 0; i--) {
            if (words[i].equals("")){
                continue;
            }
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();


    }
}
