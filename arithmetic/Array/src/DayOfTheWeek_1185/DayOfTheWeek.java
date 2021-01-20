package DayOfTheWeek_1185;


/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个{"Sunday", "Monday", "Tuesday", "Wednesday",
 * "Thursday", "Friday", "Saturday"}。
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        int day=31,month=8,year=2019;
        String result=new DayOfTheWeek().dayOfTheWeek(day,month,year);
        System.out.println(result);
    }


    public String dayOfTheWeek(int day, int month, int year) {

        String[] weekStr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //1971年1月1日为星期五
        int sum = 4;
        if (year > 1971)
            for (int i = 1971; i < year; i++) {
                sum += 365;
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) sum++;
            }
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) sum += months[i];
        if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) sum++;
        sum += day;
        return weekStr[sum % 7];

    }
}
