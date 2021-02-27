package OrderedStream_1656;

import java.util.ArrayList;
import java.util.List;


/**
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。
 * 不存在 id 相同的两个(id, value) 对。
 *
 * 设计一个流，以 任意 顺序获取 n个(id, value)对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * 实现 OrderedStream 类：
 *
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，
 * 并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个 id + 1。
 * 否则，返回一个空列表。

 */
public class OrderedStream {

    String[] list;
    int prt;
    int n;
    public static void main(String[] args) {
        int n=5;
        OrderedStream obj = new OrderedStream(n);
        List<String> param_1 = obj.insert(3,"ccccc");
        for (String s : param_1) {
            System.out.print(s);
        }

        List<String> param_2 = obj.insert(1,"aaaaa");
        for (String s : param_2) {
            System.out.println(s);
        }
        List<String> param_3 = obj.insert(2,"bbbbb");
        for (String s : param_3) {
            System.out.println(s);
        }
        List<String> param_4 = obj.insert(5,"eeeee");
        for (String s : param_4) {
            System.out.println(s);
        }
        List<String> param_5 = obj.insert(4, "ddddd");
        for (String s : param_5) {
            System.out.println(s);
        }
    }


    public OrderedStream(int n) {
        list=new String[n+1];
        prt=1;
        this.n=n;
    }

    public List<String> insert(int id, String value) {
        List<String> ans=new ArrayList<>();
        if (id!=prt) {
            list[id]=value;
            return ans;
        }
        else {

            list[id]=value;
            ans.add(value);
            prt++;
            while (prt<=n&&list[prt]!=null){

                ans.add(list[prt]);
                prt++;
            }

            return ans;
        }
    }

//
//    public List<String> insert2(int id, String value) {
//        stream[id]=value;
//        List<String>list=new ArrayList<>();
//        for(int i=ptr;i<=n;i++){
//            if (stream[i]==null)break;
//            list.add(stream[i]);ptr++;
//        }
//        return list;
//    }


}
