package CQueue_09;

import java.util.LinkedList;
import java.util.Stack;

public class CQueue {

    private Stack queue;

    public CQueue() {
        queue=new Stack();
    }

    public void appendTail(int value) {
        queue.add(value);
    }

    public int deleteHead() {
        if (queue.isEmpty()){
            return -1;
        }else {
            return (int)queue.remove(0);

        }
    }


    public class CQueue2 {

        private LinkedList<Integer> queue1,queue2;

        public CQueue2() {
            queue1=new LinkedList<Integer>();
            queue2=new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            queue1.add(value);
        }

        public int deleteHead() {
            if (!queue2.isEmpty()) return queue2.removeLast();
            if (queue1.isEmpty()){
                return -1;
            }
            while (!queue1.isEmpty()){
                queue2.addLast(queue1.removeLast());
            }

            return queue2.removeLast();
        }
    }
}


