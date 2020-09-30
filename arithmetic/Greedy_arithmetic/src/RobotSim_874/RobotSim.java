package RobotSim_874;



/*
机器人在一个无限大小的网格上行走，从点(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

        -2：向左转90 度
        -1：向右转 90 度
        1 <= x <= 9：向前移动x个单位长度
        在网格上有一些格子被视为障碍物。

        第 i个障碍物位于网格点 (obstacles[i][0], obstacles[i][1])

        机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

        返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
*/

import java.util.HashMap;
import java.util.HashSet;

public class RobotSim {

    public static void main(String[] args) {

        int[] commands={4,-1,4,-2,4};
        int[][] obstacles={{2,4}};
        int result=new RobotSim().robotSim(commands,obstacles);
        System.out.println(result);

    }

    public int robotSim(int[] commands,int[][] obstacles){

        int ans=0,direction=0,x=0,y=0;
        int[][] Direction={{0,1},{1,0},{0,-1},{-1,0}};

        HashSet<String> set=new HashSet<>();

        for (int[] obstacle : obstacles) {
            set.add(obstacle[0]+","+obstacle[1]);
        }

        for (int command : commands) {

            int next_x = 0, next_y = 0;

            if (command >= 0) {
                for (int i = 0; i < command; i++) {
                    //取得下一步的坐标
                    next_x = x + Direction[direction][0];
                    next_y = y + Direction[direction][1];
                    //若下一步有障碍物，结束当前命令，跳至下一命令
                    if (set.contains(next_x + "," + next_y)) break;
                    //否则更新坐标与最远距离
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x * x + y * y);
                }

            } else {
                direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }

        }
        return ans;
    }

}
