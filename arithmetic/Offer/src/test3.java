import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class test3 {

    public static void main(String[] args) throws IOException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(reader.readLine());
//        Integer.parseInt(reader.readLine().split(" "));


        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] input=new int[n];
        for (int i = 0; i < n; i++) {
            input[i]=sc.nextInt();
        }

        int res=0;
        Arrays.sort(input);
        for (int i = 1; i <= n; i++) {
            res+=Math.abs(i-input[i-1]);
        }
        System.out.println(res);

    }
}
