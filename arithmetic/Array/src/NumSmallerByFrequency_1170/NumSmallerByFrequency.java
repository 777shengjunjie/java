package NumSmallerByFrequency_1170;


/**
 * 我们来定义一个函数f(s)，其中传入参数s是一个非空字符串；
 * 该函数的功能是统计s 中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若s = "dcce"，那么f(s) = 2，因为最小的字母是"c"，它出现了2 次。
 *
 * 现在，给你两个字符串数组待查表queries和词汇表words，
 * 请你返回一个整数数组answer作为答案，其中每个answer[i]是满足f(queries[i])< f(W)的词的数目，
 * W是词汇表words中的词。
 */
public class NumSmallerByFrequency {

    public static void main(String[] args) {

        String[] queries={"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"},
                words={"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
        int[] result=new NumSmallerByFrequency().numSmallerByFrequency(queries,words);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] result=new int[queries.length];
        int[] count=new int[12];
        for (String word : words) {
            count[counts(word)]++;
        }

        for (int i = 9; i >0; i--) {
            count[i]+=count[i+1];
        }


        for (int i = 0; i < queries.length; i++) {
            //不能设置未count=11，因为queries可能未count【10】
            result[i]=count[counts(queries[i])+1];
        }

        return result;
    }


   /* public int[] numSmallerByFrequency2(String[] queries, String[] words) {
        //count用于统计words中所有单词的最小字母出现次数，
        //大小设置为12是为了避免下面进行判定的时候出现越界而做的冗余处理
        int[] count = new int[12];
        for (String word:words)
            count[counts(word)]++;
        //计算后缀和，现在count[i]表示最小字母出现次数大于或等于i的单词总数。
        for (int i=9;i>=0;i--)
            count[i]+=count[i+1];
        //结果数组
        int[] result = new int[queries.length];
        //遍历queries中的每个字符串，利用前面计算得到的count数组，可以直接得到答案。
        for (int i=0;i<queries.length;i++)
            result[i]=count[counts(queries[i])+1];
        return result;
    }*/

    //counts方法用于统计字符串s中最小字母出现的次数
    private int counts(String s){
//        char c = s.charAt(0);
//        int count = 1;
//        for (int i=1;i<s.length();i++){
//            char temp = s.charAt(i);
//            if (temp==c)
//                count++;
//            else if (temp<c){
//                c=temp;
//                count=1;
//            }
//        }
//        return count;
        char pre=s.charAt(0);
        int count =1;
        for (int i = 1; i < s.length(); i++) {
            char temp=s.charAt(i);
            if (pre==temp){
                count++;
            }else if (temp<pre){
                pre=temp;
                count=1;
            }
        }
        return count;
    }

}
