package com.javaedge.spring.tx.v4;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author JavaEdge
 * @date 2021/11/24
 */
public class MyDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> key = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return key.get();
    }

    public static void setDataSource(String dataSource) {
        key.set(dataSource);
    }

    public static String getDatasource() {
        return key.get();
    }

    public static void clearDataSource() {
        key.remove();
    }
}
