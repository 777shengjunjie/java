package Jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Jsoup1 {
    public static void main(String[] args) throws IOException {

        //student.xml需要放在src文件目录下
        String path = Jsoup1.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements student = document.getElementsByTag("student");
        System.out.println(student);


    }
}
