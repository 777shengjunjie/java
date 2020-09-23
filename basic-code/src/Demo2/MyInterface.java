package Demo2;

/*
注意事项：
1.接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract
2.这两个关键字修饰符，可以选择性的省略


public default 返回值类型 方法名称（参数列表）{
    方法体；
}

静方态法使用：就是将abstract和default换成static
调用方法：接口名称.静态方法（MyInterface.methodStatic）

普通私有方法，解决多个默认值方法之间代码重复的问题:
private 返回值类型 方法名称（参数列表）{
    方法体
}
静态私有方法，解决多个静态方法之间代码重复的问题:
private static 方法名称（参数列表）{
    方法体
}

接口中“成员变量”，但必须使用Public static final 三个关键字进行修饰，一但使用final就不可更改
（这三个关键字可以省略）变量必须进行赋值，名称使用完全大写,用下划线分隔MUN_STUDENT。


 */


public interface MyInterface {

    public abstract void method();

    //public 可以省略
    public default void  methodDefault(){
        System.out.println("默认方法");
    }

    public static void  methodStatic(){
        System.out.println("这是静态方法");
    }
}
