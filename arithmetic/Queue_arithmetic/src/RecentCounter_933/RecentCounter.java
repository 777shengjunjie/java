package RecentCounter_933;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
 * 并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 */
public class RecentCounter {

    private Queue<Integer> q;

    public static void main(String[] args) {

        RecentCounter obj = new RecentCounter();
        int param_1 = obj.ping(1);
        System.out.println(param_1);
        int param_2 = obj.ping(100);
        System.out.println(param_2);
        int param_3 = obj.ping(3001);
        System.out.println(param_3);
        int param_4 = obj.ping(3002);
        System.out.println(param_4);


    }

    public RecentCounter() {
        q=new LinkedList<>();
    }

    public int ping(int t) {

        q.add(t);
        while (q.peek()<(t-3000)){
            q.poll();
        }
        return q.size();

    }
}
