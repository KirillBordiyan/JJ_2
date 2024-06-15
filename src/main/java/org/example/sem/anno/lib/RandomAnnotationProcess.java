package org.example.sem.anno.lib;

import java.lang.reflect.Field;

public class RandomAnnotationProcess {
    public static void processAnnotation(Object obj) {
        java.util.Random random = new java.util.Random();
        Class<?> objClass = obj.getClass();
        //instance of Person
        //AnnotationsMain.Person.class.isInstance(obj)
        //obj.getClass().isAssignableFrom(AnnotationsMain.Person.class)

        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Random.class) &&
                    field.getType().isAssignableFrom(int.class)) {
                //получение атрибутов аннотации
                Random annotation = field.getAnnotation(Random.class);
                int min = annotation.min();
                int max = annotation.max();

                try {
                    field.setAccessible(true);
                    field.set(obj, random.nextInt(min, max));
                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось вставить значение в поле " + e.getMessage());
                }
            }

        }
    }
}
