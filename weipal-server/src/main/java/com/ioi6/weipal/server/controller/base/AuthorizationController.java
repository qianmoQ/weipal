package com.ioi6.weipal.server.controller.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * authorization
 * Created by shicheng on 2017/5/11.
 */
@RestController
@RequestMapping(value = "/authorization")
@Slf4j
public class AuthorizationController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    void authorization() {
        log.info("authorization");
    }

    @RequestMapping(value = "/error", method = RequestMethod.POST)
    String error() {
        return "email not found or password error";
    }

}
