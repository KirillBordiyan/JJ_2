package org.example.hw.annotation;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class RandomDateAnnotation {
    private static final String MESSAGE = "Max time cannot be less of min";
    private static final java.util.Random random = new java.util.Random();

    // реализация присвоения значений полю
    public static void processAnnotation(Object obj) {
        Class<?> objClass = obj.getClass();
        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomDate.class) &&
                    field.getType().isAssignableFrom(Date.class)) {
                processRandomDate(obj, field);
            }
            if (field.isAnnotationPresent(RandomDate.class) &&
                    field.getType().isAssignableFrom(LocalDate.class)) {
                processRandomLocalDate(obj, field);
            }
        }
    }

    private static void processRandomLocalDate(Object obj, Field field) {
        RandomDate params = field.getAnnotation(RandomDate.class);
        long min = params.min();
        long max = params.max();
        String zone = params.zone();

        try {
            if (min > max) {
                throw new RuntimeException(MESSAGE);
            }
            field.setAccessible(true);
            ZoneId zoneId = ZoneId.of(zone);
            ZonedDateTime zdt = ZonedDateTime.ofInstant(
                    Instant.ofEpochMilli(
                            random.nextLong(min, max)),
                    zoneId);

            System.out.println();
            System.out.println("Для пояса " + zone);
            System.out.println(zdt);
            System.out.println(zdt.toLocalDate());
            System.out.println();

            field.set(obj, zdt.toLocalDate());
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

    private static void processRandomDate(Object obj, Field field) {

        RandomDate params = field.getAnnotation(RandomDate.class);
        long min = params.min();
        long max = params.max();

        try {
            if (min > max) {
                throw new RuntimeException(MESSAGE);
            }
            field.setAccessible(true);
            field.set(obj, new Date(random.nextLong(min, max)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
