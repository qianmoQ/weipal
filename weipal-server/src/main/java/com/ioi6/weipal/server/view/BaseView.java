package com.ioi6.weipal.server.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * base view
 * Created by shicheng on 2017/5/11.
 */
@Controller
public class BaseView {

    /**
     * index view
     *
     * @return index page
     */
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    String index() {
        return "index";
    }

}
