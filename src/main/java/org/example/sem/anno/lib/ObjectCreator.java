package org.example.sem.anno.lib;

import java.lang.reflect.Constructor;

public class ObjectCreator {
    public static <T> T createObj(Class<T> tClass){
        try{
            //так стараться не делать, нарушается приватность
            Constructor<T> constr = tClass.getDeclaredConstructor();
            constr.setAccessible(true);
            //

            T obj = constr.newInstance();
            RandomAnnotationProcess.processAnnotation(obj);
            return obj;
        } catch (Exception e){
            System.err.println("не вышло");
            return null;
        }
    }
}
