package com.ioi6.weipal.server.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * home view
 * Created by shicheng on 2017/5/11.
 */
@Controller
@RequestMapping(value = "home")
public class HomeView {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    String home() {
        return "home/dashboard";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    String query() {
        return "home/query";
    }

}
