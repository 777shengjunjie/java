package Demo6;

import java.util.Arrays;
import java.util.List;

public class Map {
    public static void main(String[] args) {
        int[] q={1,2,3};
        T t=new T(q);



        System.out.println(t);
    }
    public static class T{
        int[] t;

        public T(int[] t) {
            this.t = t;
        }

        public T() {
        }

        @Override
        public String toString() {
            return "T{" +
                    "t=" + Arrays.toString(t) +
                    '}';
        }

        public int[] getT() {
            return t;
        }

        public void setT(int[] t) {
            this.t = t;
        }
    }
}
