import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(i); // 集合添加元素
        }
        a.sort(((o1, o2) -> {return o2-o1;}));
        System.out.println(a); // 打印 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        Object[] b = a.toArray(); // 转化为数组，目的为了的得到集合长度的另外一种表示
        System.out.println(b.length);// 数组长度打印
        for (int i = 0; i < b.length; i++) { // 循环 利用数组得到原来集合的长度
            a.remove(0); // 集合操作删除 这里只删除索引为0，操作后集合是变了的，前面删除后后面补位上去
        }
        System.out.println(a); // 打印 []
        System.out.println(a.size()); // 0
    }

}
