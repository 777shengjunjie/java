package Demo10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(55554);

        while (true){
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try{
                        InputStream is = socket.getInputStream();
                        /*
                                byte[] bytes=new byte[1024];
                                int len=0;
                                while ((len=is.read(bytes))!=-1){
                                    System.out.println(new String(bytes,0,len));
                                }*/

                        BufferedReader br=new BufferedReader(new InputStreamReader(is));

                        String s = br.readLine();
                        String[] s1 = s.split(" ");
                        //System.out.println(s1[1]);
                        String htmlPath = s1[1].substring(1);

                        //FileInputStream fis=new FileInputStream("E:\\学习\\basic-code\\src\\Web\\login.html");
                        FileInputStream fis=new FileInputStream(htmlPath);
                       // System.out.println(fis);
                        OutputStream os = socket.getOutputStream();

                        //协议响应固定开头
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        byte[] bytes=new byte[1024]; 
                        int len=0;
                        while ((len=fis.read(bytes))!=-1){
                            os.write(bytes,0,len);
                        }

                        fis.close();
                        os.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }

                }
            }).start();
        }


      //  server.close();




    }
}
