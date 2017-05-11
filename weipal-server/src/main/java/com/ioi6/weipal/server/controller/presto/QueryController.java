package com.ioi6.weipal.server.controller.presto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * presto query
 * Created by shicheng on 2017/5/11.
 */
@RestController
@RequestMapping(value = "/api/${weipal.api.version}/presto/query")
@Slf4j
public class QueryController {

    @RequestMapping(value = "task", method = RequestMethod.GET)
    void queryTask() {

    }

}
