package com.github.kyrenesjtv.multithread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TimeGrouping {

    public static void main(String[] args) {
        List<String> timeStrings = Arrays.asList(
                "2023-10-01 14:30:00",
                "2023-10-01 14:31:00",
                "2023-10-01 14:35:00",
                "2023-10-01 14:36:00",
                "2023-10-01 14:45:00",
                "2023-10-01 15:05:00",
                "2023-10-01 15:06:00",
                "2023-10-01 15:10:00",
                "2023-10-02 10:00:00",
                "2023-10-02 10:15:00",
                "2023-10-02 10:25:00"
        );

        Map<String, List<String>> groupedTimes = groupTimesByMinuteInterval(timeStrings);

        // Print the grouped times
        groupedTimes.forEach((key, value) -> {
            System.out.println("Group: " + key);
            value.forEach(System.out::println);
        });
    }

    public static Map<String, List<String>> groupTimesByMinuteInterval(List<String> timeStrings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Map<String, List<String>> groupedTimes = new TreeMap<>();

        for (String timeString : timeStrings) {
            LocalDateTime dateTime = LocalDateTime.parse(timeString, formatter);
            int year = dateTime.getYear();
            int month = dateTime.getMonthValue();
            int day = dateTime.getDayOfMonth();
            int hour = dateTime.getHour();
            int minute = dateTime.getMinute();

            // Determine the minute interval (0-9, 10-19, 20-29, 30-39, 40-49, 50-59)
            int interval = minute / 5 * 5;
//            if (minute % 10 != 0) {
//                interval += 10; // Adjust for non-zero minutes within the interval
//            } else if (interval == 60) {
//                interval = 50; // Group 60 minutes into 50-60 interval
//            }

            String groupKey = String.format("%d-%02d-%02d %02d:%02d",
                    year, month, day, hour, interval);

            groupedTimes.computeIfAbsent(groupKey, k -> new ArrayList<>()).add(timeString);
        }

        return groupedTimes;
    }
}