/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
