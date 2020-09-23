package Demo9;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class DemoTry {

    public static void main(String[] args) throws IOException {
      /*  FileWriter a=new FileWriter("C://d");
        FileWriter b=new FileWriter("C://d");
        try(a;b){

        }catch(IOException e){
            System.out.println(e);
        }*/
        String a="1.gg";
        String[] b=a.split("\\.") ;
        System.out.println(b[0]+"\r\n"+b[1]);

    }
}
