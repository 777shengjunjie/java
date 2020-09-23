package Demo3;

import Demo1.User;

public class Computer {

    public void powerOn(){
        System.out.println("电脑开机了");
    }

    public void powerOff(){
        System.out.println("电脑关机了");
    }

    public void useDevice(USB usb){

        usb.on();

        if (usb instanceof Mouse){
            Mouse mouse=(Mouse)usb;
            mouse.click();
        }else if (usb instanceof KeyBoard){
            KeyBoard keyBoard=(KeyBoard)usb;
            keyBoard.type();
        }

        usb.off();

    }


}
