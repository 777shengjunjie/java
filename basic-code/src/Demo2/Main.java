package Demo2;

public class Main {

    public static void main(String[] args) {
        MyInterfaceImpl myInterface=new MyInterfaceImpl();
        myInterface.method();

        MyInterface.methodStatic();
    }
}
