package Demo3;

public class KeyBoard implements USB {
    @Override
    public void on() {

        System.out.println("键盘打开了");
    }

    @Override
    public void off() {
        System.out.println("键盘关机了");
    }


    public void type(){
        System.out.println("键盘输入");

    }
}
