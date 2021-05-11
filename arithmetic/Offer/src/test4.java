import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class test4 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(reader.readLine());
        int[] N=new int[t];
        String[] seat=new String[t];
        int[] wait=new int[t];
        String[] sex=new String[t];
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < t; i++) {
            N[i]=Integer.parseInt(reader.readLine());
            seat[i]=reader.readLine();
            wait[i]=Integer.parseInt(reader.readLine());
            sex[i]=reader.readLine();
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < wait[i]; j++) {
                boolean flag=false;
                if (sex[i].charAt(j)=='M'){
                    for (int k = 0; k < N[i]; k++) {
                        if (seat[i].charAt(k)=='1'){
                            res.add(k+1);
                            seat[i]=seat[i].substring(0,k)+'2'+seat[i].substring(k+1);
                            flag=true;
                            break;
                        }
                    }
                    if (flag) continue;
                    for (int k = 0; k < N[i]; k++) {
                        if (seat[i].charAt(k)=='0'){
                            res.add(k+1);
                            seat[i]=seat[i].substring(0,k)+'1'+seat[i].substring(k+1);
                            break;
                        }
                    }
                }else {
                    for (int k = 0; k < N[i]; k++) {
                        if (seat[i].charAt(k)=='0'){
                            res.add(k+1);
                            String s=seat[i].substring(0,k);
                            seat[i]=seat[i].substring(0,k)+'1'+seat[i].substring(k+1);
                            flag=true;
                            break;
                        }
                    }
                    if (flag) continue;
                    for (int k = 0; k < N[i]; k++) {
                        if (seat[i].charAt(k)=='1'){
                            res.add(k+1);
                            String s=seat[i].substring(0,k);
                            seat[i]=seat[i].substring(0,k)+'2'+seat[i].substring(k+1);
                            break;
                        }
                    }
                }

            }
        }

        for (Integer re : res) {
           writer.write(re.toString());
           writer.newLine();
        }

        writer.flush();

    }
}
