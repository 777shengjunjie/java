package MovingCount_13;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    int res=0;
    boolean[][] visited;

    public static void main(String[] args) {
        int result=new MovingCount().movingCount(1,2,1);
        System.out.println(result);
    }

    public int movingCount(int m, int n, int k) {

        visited=new boolean[m][n];
        getCount(0, 0, m, n, k);

        return res;
    }

    public void getCount(int row,int col,int m, int n, int k){
        if (row>=m||col>=n||visited[row][col]||sumNum(row,col)>k) return;
        visited[row][col]=true;
        if (sumNum(row,col)<=k) res++;
        getCount(row+1,col,m,n,k);
        getCount(row,col+1,m,n,k);

    }

    public int sumNum(int m,int n){
        int sum=0;
        while(m!=0){
            sum+=m%10;
            m=m/10;
        }
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }

    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }




}
