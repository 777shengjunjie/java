package KthLargest_703;





/*
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

        你的KthLargest类需要一个同时接收整数k 和整数数组nums的构造器，它包含数据流中的初始元素。
        每次调用KthLargest.add，返回当前数据流中第K大的元素。
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {


    private int k;
    private PriorityQueue<Integer> pqueue;
    public static void main(String[] args) {

        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int i1=kthLargest.add(3);          // returns 4
        System.out.println(i1);
        int i2=kthLargest.add(5);
        System.out.println(i2);         // returns 5
        System.out.println(kthLargest.add(10));        // returns 5
        System.out.println(kthLargest.add(9));         // returns 8
        System.out.println(kthLargest.add(4));        // returns 8




    }

    public KthLargest(int k, int[] nums) {

        this.k = k;
        pqueue=new PriorityQueue<>();
        for (int num : nums) {

            //pqueue.offer(num);
        }

    }

    public int add(int val) {


        if (pqueue.size() < k) {
            pqueue.add(val);
        } else if (val > pqueue.peek()) {
            pqueue.poll();
            pqueue.add(val);
        }

        return pqueue.peek();


      /*  List<Integer> list=new ArrayList<>();
        int i=1;
        int ans=0;
        pqueue.offer(val);
        while (i<k){
            list.add(pqueue.poll());
            i++;
        }
        ans=pqueue.peek();
        for (Integer integer : list) {
            pqueue.offer(integer);
        }
        return ans;*/

    }

}
