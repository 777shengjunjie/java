package LastStoneWeight_1046;

/*
有一堆石头，每块石头的重量都是正整数。

        每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：

        如果x == y，那么两块石头都会被完全粉碎；
        如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
        最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
*/


import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {

        int [] stones={2,7,4,1,8,1};
        int result=new LastStoneWeight().lastStoneWeight(stones);
        System.out.println(result);


    }

    @Test
    public int lastStoneWeight(int[] stones){

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size()>1){
            int x=priorityQueue.poll();
            int y=priorityQueue.poll();
            if (x==y) continue;
            else {
                priorityQueue.offer(Math.abs(x-y));
            }
        }


        if (priorityQueue.isEmpty()) return 0;

        return priorityQueue.peek();


    }
}
