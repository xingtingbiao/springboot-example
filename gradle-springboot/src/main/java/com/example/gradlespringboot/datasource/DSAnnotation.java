package com.example.gradlespringboot.datasource;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DSAnnotation {
    String value() default "datasource1";
}
