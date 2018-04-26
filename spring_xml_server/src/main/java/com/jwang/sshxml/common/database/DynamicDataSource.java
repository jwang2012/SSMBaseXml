package com.jwang.sshxml.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author jwang
 * 描述：基于spring的AbstractRoutingDataSource类实现动态数据源切换
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource 
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        // 从自定义的位置获取数据源标识
        return DynamicDataSourceHolder.getDataSource();
    }

}
