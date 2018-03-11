package others;

import sun.util.calendar.BaseCalendar;

import java.util.Calendar;

public class DateTest {
    public static void main(String[] args) {
        // 获得一个日历对象
        Calendar c = Calendar.getInstance();
        // 得到本月的那一天
        int today = c.get(Calendar.DAY_OF_MONTH);
// 然后判断是不是本月的第一天
        if (today ==1 ){
//是
        }else{
//否
        }
    }

}
