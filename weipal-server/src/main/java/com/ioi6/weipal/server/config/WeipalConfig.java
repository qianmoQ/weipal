package com.ioi6.weipal.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * application config
 * Created by shicheng on 2017/5/11.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.ioi6.weipal")
public class WeipalConfig {
}
