package GetImportance_690;


import UtilClass.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度和直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，
 * 员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，
 * 因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 */
public class GetImportance {

    public int importance=0;

    public static void main(String[] args) {

        Employee el1=new Employee();
        el1.id=1;
        el1.importance=5;
        el1.subordinates=new ArrayList<>(){
            {
                add(2);
                add(3);
            }
        };

        Employee el2=new Employee();
        el2.id=2;
        el2.importance=3;
        el2.subordinates=new ArrayList<>();

        Employee el3=new Employee();
        el3.id=3;
        el3.importance=3;
        el3.subordinates=new ArrayList<>();


        List<Employee> employees=new ArrayList<>(){
                {
                    add(el1);
                    add(el2);
                    add(el3);
                }
        };

        int id =1;

        int result =new GetImportance().getImportance(employees,id);
        System.out.println(result);
    }

    public int getImportance(List<Employee> employees,int id){

        return helper(employees,id);

    }

    private int helper(List<Employee> employees, int id) {

        for (Employee employee : employees) {
            if (employee.id==id){

                if (employee.subordinates.isEmpty()) {
                    importance=importance+employee.importance;
                    return importance;
                }

                while (!employee.subordinates.isEmpty()){
                    int sid=employee.subordinates.remove(0);
                    helper(employees,sid);
                }

                importance+=employee.importance;

            }
        }

        return importance;

    }

    Map<Integer, Employee> emap;
    public int getImportance2(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }



}
