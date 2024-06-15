package org.example.hw.annotation;

import java.lang.reflect.Constructor;

public class SomeEventFactory {
    public static <T> T createObj(Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getConstructor();
            T obj = constructor.newInstance();
            RandomDateAnnotation.processAnnotation(obj);
            return obj;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
