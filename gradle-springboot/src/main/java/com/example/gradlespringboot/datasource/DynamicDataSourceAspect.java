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
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        try {
            DSAnnotation annotationOfClass = (DSAnnotation)point.getSignature().getDeclaringType().getAnnotation(DSAnnotation.class);
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            DSAnnotation annotation = method.getAnnotation(DSAnnotation.class);
            annotation = annotation == null ? annotationOfClass : annotation;
            dataSource = annotation.value();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("execution(* com.example.gradlespringboot.mapper..*.*(..))")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
