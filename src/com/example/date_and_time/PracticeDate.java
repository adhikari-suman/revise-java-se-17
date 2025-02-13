package com.example.date_and_time;

import java.time.*;

public class PracticeDate {
    public static void main(String[] args) {
        // Local date and time
        LocalDate     today         = LocalDate.now();
        LocalTime     timeToday     = LocalTime.now();
        LocalDateTime dateTimeToday = LocalDateTime.of(today, timeToday);

        System.out.printf("%n\t\t\tLocal Date Time(s)%n");
        System.out.printf("Today is %s and time is %s.%n", today, timeToday);
        System.out.printf("Today is %s.%n", dateTimeToday);

        // Zoned date and times
        ZonedDateTime zonedDateTimeToday = ZonedDateTime.now();
        System.out.printf("%n\t\t\tZoned Date Time(s)%n");
        System.out.printf("The time in %s is %s.%n", zonedDateTimeToday.getZone(), zonedDateTimeToday);

        // Date difference - Duration and Periods
        ZonedDateTime birthday = ZonedDateTime.of(2001, 11, 01, 11, 11, 11, 0, ZoneId.of("Asia/Shanghai"));
        Duration      duration = Duration.between(zonedDateTimeToday, birthday); // in hours, minutes and seconds
        Period period = Period.between(zonedDateTimeToday.toLocalDate(), birthday.toLocalDate());
        System.out.printf("%n\t\t\tDate difference between Zoned Date Time(s)%n");
        System.out.printf("You are this old: %s%n", duration);
        System.out.printf("You are this old: %s%n", period);


        // Instant - time since epoch
        Instant instant = Instant.now();
        System.out.printf("%n\t\t\tInstant - Machine Time since epoch (January 1, 1970 UTC)%n");
        System.out.printf("Machine time is %s.%n", instant);

    }
}
