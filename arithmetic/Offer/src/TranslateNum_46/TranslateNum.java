package TranslateNum_46;

public class TranslateNum {

    public static void main(String[] args) {
        int num=1068385902;
        int result=new TranslateNum().translateNum(num);
        System.out.println(result);
    }

    public int translateNum(int num) {
        if (num<10) return 1;
        int a=1,b=1,c=0;
        String s = String.valueOf(num);
        for (int i = 1; i < s.toCharArray().length; i++) {
            int value= Integer.parseInt(s.charAt(i-1)+"")*10+Integer.parseInt(s.charAt(i)+"");
//            if(i==1&&value<26) {
//                a=1;
//            }
            if (value<26&&value>=10){
                c=a+b;
            }else {
                c=b;
            }
            a=b;
            b=c;

        }

        return c;
    }

    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


}
