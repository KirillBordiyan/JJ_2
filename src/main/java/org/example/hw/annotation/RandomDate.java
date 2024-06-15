package org.example.hw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    //ZoneId zoneField() || String zone()
    long min() default 1704067200000L;
    long max() default 1735689600000L;
    String zone() default "Europe/London";
}
