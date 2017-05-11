package com.ioi6.weipal.server.controller.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * authorization
 * Created by shicheng on 2017/5/11.
 */
@RequestMapping(value = "/authorization")
public class AuthorizationController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    void authorization() {
    }

}
