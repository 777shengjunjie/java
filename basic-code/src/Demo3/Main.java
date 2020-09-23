package Demo3;

import java.security.Key;

public class Main {


    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.powerOn();

        //向上转型
        USB usb=new Mouse();
        computer.useDevice(usb);//

        KeyBoard keyBoard=new KeyBoard();
        computer.useDevice(keyBoard);//向上转型

        computer.useDevice(new Mouse());//匿名对象

        computer.powerOff();
    }
}
