package com.example.gradlespringboot.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DynamicDataSourceAspect {

    @Before("execution(* com.example.gradlespringboot.mapper..*.*(..))")
    public void before(JoinPoint point) {
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        DSAnnotation annotationOfClass = (DSAnnotation)point.getSignature().getDeclaringType().getAnnotation(DSAnnotation.class);
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        DSAnnotation annotation = method.getAnnotation(DSAnnotation.class);
        annotation = annotation == null ? annotationOfClass : annotation;
        if (null != annotation) dataSource = annotation.value();
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("execution(* com.example.gradlespringboot.mapper..*.*(..))")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
