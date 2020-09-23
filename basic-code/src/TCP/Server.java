package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {


    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(18888);


        while (true){

            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{

                        InputStream is = socket.getInputStream();

                        String fileName="S"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";

                        File file=new File("E:\\学习\\Server");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                        int len=0;
                        byte[] bytes=new byte[1024];

                        FileOutputStream fos=new FileOutputStream(file+"\\"+fileName);
                        while ((len=is.read(bytes))!=-1){
                            fos.write(bytes,0,len);
                        }

                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());

                        socket.close();
                        fos.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }

                }
            }).start();


        }



    }
}
