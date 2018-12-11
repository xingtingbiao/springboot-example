package com.example.gradlespringboot.datasource;

public class DataSourceContextHolder {

    public static final String DEFAULT_DS = "datasource1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();


    // 设置数据源名
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }

}
