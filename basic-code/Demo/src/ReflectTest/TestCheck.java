package ReflectTest;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单测试框架
 *
 * 当主方法执行后，会自动执行被检测的所有的方法（加了Check注解的方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator c=new Calculator();
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();

        int num=0;

        BufferedWriter bw=new BufferedWriter(new FileWriter("Bug.txt"));

        for (Method method : methods) {

            if (method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                   num++;
                   bw.write(method.getName()+ "方法出异常");
                   bw.newLine();
                   bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
                   bw.newLine();
                   bw.write("方法出现了"+e.getCause().getMessage());
                   bw.newLine();
                   bw.write("------------------------");
                   bw.newLine();

                }
            }

        }

        bw.write("本次测试一共出现"+num+"异常");
        bw.flush();
        bw.close();
    }


}
