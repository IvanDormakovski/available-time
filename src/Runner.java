import java.text.ParseException;

public class Runner {
    public static void main(String[] args) throws ParseException {
        FreeTime freeTime = new FreeTime();
//        String[] str = new String[] {"10:00AM-12:30PM","02:00PM-02:45PM","09:10AM-09:50AM"};    // 01:30
        String[] str = new String[] {"08:00AM-09:34AM","02:00PM-02:45PM","05:00PM-05:30PM","11:10AM-01:15PM"};    // 02:15
        System.out.print(freeTime.MostFreeTime(str));
    }
}
