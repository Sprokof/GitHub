package github.util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    private static final Map<String, Integer> months = new HashMap<>();

    static {
        months.put("Jan", 1);
        months.put("Feb", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("Jun", 6);
        months.put("Jul", 7);
        months.put("Aug", 8);
        months.put("Sep", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dec", 12);
    }

    public static LocalDate parse(String expirationDate) {
        if (isToday(expirationDate)) return LocalDate.now();
        String parsedDate = expirationDate.replaceAll("(\\w{2}\\s\\w{3},\\s)", "");
        String[] dateItems = parsedDate.split("\\s");
        int month = extractNumericMonth(dateItems[0]);
        int day = Integer.parseInt(dateItems[1]);
        int year = Integer.parseInt(dateItems[2]);
        return LocalDate.of(year, month, day);
    }

    private static int extractNumericMonth(String month) {
        return months.get(month);
    }


    private static boolean isToday(String expirationDate) {
        return expirationDate.equals("today");
    }

}
