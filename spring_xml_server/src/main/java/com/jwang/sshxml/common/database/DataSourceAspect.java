package com.jwang.sshxml.common.database;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class DataSourceAspect 
{
	private static final Logger LOGGER = Logger.getLogger(DataSourceAspect.class);

    /**
     * ����Ŀ�귽������ȡ��@DataSourceָ��������Դ��ʶ�����õ��̴߳洢���Ա��л�����Դ
     * 
     * @param point
     * @throws Exception
     */
    public void intercept(JoinPoint point) throws Exception 
    {
        Class<?> target = point.getTarget().getClass();
        
        MethodSignature signature = (MethodSignature) point.getSignature();
        
        // Ĭ��ʹ��Ŀ�����͵�ע�⣬���û����ʹ����ʵ�ֽӿڵ�ע��
        for (Class<?> clazz : target.getInterfaces())
        {
            resolveDataSource(clazz, signature.getMethod());
        }
        
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * ��ȡĿ����󷽷�ע�������ע���е�����Դ��ʶ
     * 
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) 
    {
        try 
        {
            Class<?>[] types = method.getParameterTypes();
            // Ĭ��ʹ������ע��
            if (clazz.isAnnotationPresent(DataSource.class))
            {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
            // ����ע����Ը�������ע��
            Method m = clazz.getMethod(method.getName(), types);
            
            if (m != null && m.isAnnotationPresent(DataSource.class)) 
            {
                DataSource source = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
            }
        }
        catch (Exception e) 
        {
        	LOGGER.error(clazz + ":" + e.getMessage());
        }
    }

}
