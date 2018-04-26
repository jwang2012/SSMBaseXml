package com.jwang.sshxml.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author jwang
 * ����������spring��AbstractRoutingDataSource��ʵ�ֶ�̬����Դ�л�
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource 
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        // ���Զ����λ�û�ȡ����Դ��ʶ
        return DynamicDataSourceHolder.getDataSource();
    }

}
