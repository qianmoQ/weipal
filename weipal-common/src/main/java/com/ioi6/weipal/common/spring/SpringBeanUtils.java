package com.ioi6.weipal.common.spring;

import org.springframework.context.ApplicationContext;

/**
 * spring bean util
 * Created by shicheng on 2017/5/11.
 */
public class SpringBeanUtils {

    private static ApplicationContext context;

    /**
     * set a application context
     *
     * @param context context
     */
    public static void setContext(ApplicationContext context) {
        SpringBeanUtils.context = context;
    }

    /**
     * get bean by class type
     *
     * @param clazz class
     * @param <T>
     * @return class bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * get bean by id
     *
     * @param id bean id
     * @return bean
     */
    public static Object getBean(String id) {
        return context.getBean(id);
    }

}
