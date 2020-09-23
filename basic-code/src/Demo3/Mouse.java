package Demo3;

public class Mouse implements USB {
    @Override
    public void on() {
        System.out.println("鼠标打开了");
    }

    @Override
    public void off() {
        System.out.println("鼠标关机了");
    }

    public void  click(){

        System.out.println("鼠标输入");

    }
}
