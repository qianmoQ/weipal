package com.ioi6.weipal.server.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * user view
 * Created by shicheng on 2017/5/11.
 */
@Controller
@RequestMapping(value = "user")
public class UserView {

    /**
     * login view
     *
     * @return login page
     */
    @RequestMapping(value = {"login", "signIn"}, method = RequestMethod.GET)
    String login() {
        return "login";
    }

    /**
     * register view
     *
     * @return register page
     */
    @RequestMapping(value = {"register", "signUp"}, method = RequestMethod.GET)
    String register() {
        return "register";
    }

}
