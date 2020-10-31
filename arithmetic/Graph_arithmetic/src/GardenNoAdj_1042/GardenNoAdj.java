package GardenNoAdj_1042;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有N个花园，按从1到N标记。在每个花园中，你打算种下四种花之一。
 * paths[i] = [x, y]描述了花园x 到花园y的双向路径。
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * 以数组形式返回选择的方案作为答案answer，其中answer[i]为在第(i+1)个花园中种植
 * 的花的种类。花的种类用 1, 2, 3,4 表示。保证存在答案。
 */
public class GardenNoAdj {

    public static void main(String[] args) {


        int N = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        int [] result=new GardenNoAdj().gardenNoAdj(N,paths);
        for (int i : result) {
            System.out.println(i);
        }

    }


    public int[] gardenNoAdj(int N, int[][] paths) {


            int[] ans = new int[N];
            LinkedList<Integer>[] adj =(LinkedList<Integer>[]) new LinkedList[N + 1];//邻接表数组
            for(int i = 0; i < adj.length; i++)
                adj[i] = new LinkedList<Integer>();
            for(int[] temp : paths) {//建立邻接表
                adj[temp[0]].add(temp[1]);
                adj[temp[1]].add(temp[0]);
            }
            for(int i = 1; i <= N; i++) {//从1号花园开始种花
                boolean[] color = new boolean[5];//每个花园初始都有4种可选，false意为没被用过
                for(int id : adj[i])
                    color[ans[id - 1]] = true;//邻接顶点花园使用过的种类，不能再用
                for(int j = 1; j <= 4; j++) {//找剩余的可用种类
                    if(!color[j]) {
                        ans[i - 1] = j;
                        break;
                    }
                }
            }
            return ans;
        }



}
