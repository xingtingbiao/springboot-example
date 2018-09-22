package com.example.spring.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectUserInfo {
  @AliasFor("name")
  String value() default "";

  @AliasFor("value")
  String name() default "";

  boolean required() default true;

  boolean notEmpty() default true;

  int maxLength() default Integer.MAX_VALUE;

  String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";
}
