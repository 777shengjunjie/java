package CountStudents_1700;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。
 * 所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 *
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]
 * 是栈里面第i个三明治的类型（i = 0是栈的顶部），students[j]
 * 是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）.
 * 请你返回无法吃午餐的学生数量

 */
public class CountStudents {


    public static void main(String[] args) {

        int[] students={1,1,0,0};
        int[] sandwiches={0,1,0,1};
        int result=new CountStudents().countStudents(students,sandwiches);
        System.out.println(result);
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int ans=0;
        Queue<Integer> studentsList = new LinkedList<>();

        for (int student : students) {
            studentsList.add(student);
        }

        int i=0;
        while (i<sandwiches.length){
            int studentTop=studentsList.remove();
            if (sandwiches[i]==studentTop){
                ans++;
                i++;
            }else {
                studentsList.add(studentTop);
            }
        }

        return students.length-ans;
        
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        if (students == null || students.length == 0) return 0;
        if (sandwiches == null || sandwiches.length == 0) return students.length;
        // stuLike[0] 喜欢圆形的学生数，stuLike[1]喜欢方形的学生数
        int[] stuLike = new int[2];
        for (int student : students) {
            stuLike[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (stuLike[sandwiches[i]] == 0) {
                // 学生是转圈来的，此时说明喜欢圆形或者方形的学生已经没有了，顶部的三明治没人取走了。
                break;
            }
            // 对应的学生满足一个，减少一个
            stuLike[sandwiches[i]]--;
        }
        return stuLike[0] + stuLike[1];
    }


}
