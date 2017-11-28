package com.ioi6.weipal.server;

import com.ioi6.weipal.common.spring.SpringBeanUtils;
import com.ioi6.weipal.server.config.WeipalConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

/**
 * application main
 * Created by shicheng on 2017/5/11.
 */
@Slf4j
public class WeipalServerLauncher {

    public static void main(String[] args) {
        log.info("server is start, start time is: {}", new Date());
        long startTime = System.currentTimeMillis();
        ApplicationContext context = SpringApplication.run(WeipalConfig.class, args);
        SpringBeanUtils.setContext(context);
        long endTime = System.currentTimeMillis();
        log.info("server start success. use time: {} ms", (endTime - startTime));
    }

}
