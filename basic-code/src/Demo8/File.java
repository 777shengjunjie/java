package Demo8;

import java.io.FileInputStream;
import java.io.IOException;

public class File {

    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("E:\\学习\\test.txt");
        int len=0;
        while ((len=fis.read())!=-1){
            System.out.println((char)(len));
        }

        fis.close();
/*
        相当于fis.read()运行了两次，每次指针往下移动一个字节，相当于移动了两个字节
        System.out.println("======================");

        while (fis.read()!=-1){
            System.out.println(fis.read());
        }

        fis.close();
        */
    }
}
