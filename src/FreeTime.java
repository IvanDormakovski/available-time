import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FreeTime {
    public String MostFreeTime(String[] strArr) throws ParseException {
        List<String> startEvents = new ArrayList<>();
        List<String> endEvents = new ArrayList<>();
        List<String> freeTime = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String[] times = strArr[i].split("-");
            startEvents.add(times[0]);
            endEvents.add(times[1]);
        }

        startEvents = sortTimeAscending(startEvents);
        endEvents = sortTimeAscending(endEvents);
        System.out.println(startEvents);
        System.out.println(endEvents);

        for (int i = 1; i < startEvents.size(); i++) {
            int j = i - 1;
            DateFormat format = new SimpleDateFormat("hh:mma");
            Date dateI = format.parse(startEvents.get(i));
            Date dateJ = format.parse(endEvents.get(j));
            long difference = Math.abs(dateI.getTime() - dateJ.getTime());
            long differenceHours = (difference / (60 * 60 * 1000)) % 24;
            long differenceMinutes = (difference / (60 * 1000) % 60);
            StringBuilder result = new StringBuilder();
            StringBuilder hour = new StringBuilder();
            StringBuilder minutes = new StringBuilder();
            if (differenceHours < 10) {
                hour.append("0").append(differenceHours).append(":");
            } else {
                hour.append(differenceHours).append(":");
            }
            if (differenceMinutes < 10) {
                minutes.append("0").append(differenceMinutes);
            } else {
                minutes.append(differenceMinutes);
            }
            result.append(hour).append(minutes);
            freeTime.add(result.toString());
        }

        freeTime = sortFreeAscending(freeTime);
        Collections.reverse(freeTime);

        return freeTime.get(0);
    }

    private List<String> sortTimeAscending(List<String> events) {
        Collections.sort(events, new Comparator<String>() {
            DateFormat format = new SimpleDateFormat("hh:mma");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return format.parse(o1).compareTo(format.parse(o2));
                } catch (Exception e) {
                    System.out.println("Mistake in sort method");
                }
                return 0;
            }
        });
        return events;
    }

    private List<String> sortFreeAscending(List<String> freeTime) {
        Collections.sort(freeTime, new Comparator<String>() {
            DateFormat format = new SimpleDateFormat("hh:mm");

            @Override
            public int compare(String o1, String o2) {
                try {
                    return format.parse(o1).compareTo(format.parse(o2));
                } catch (Exception e) {
                    System.out.println("Mistake in sort method");
                }
                return 0;
            }
        });
        return freeTime;
    }
}
