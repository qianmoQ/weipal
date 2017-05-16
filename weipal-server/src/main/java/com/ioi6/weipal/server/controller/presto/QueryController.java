package com.ioi6.weipal.server.controller.presto;

import com.ioi6.weipal.model.result.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * presto query
 * Created by shicheng on 2017/5/11.
 */
@RestController
@RequestMapping(value = "/api/${weipal.api.version}/presto/query")
@Slf4j
public class QueryController {

    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    ReturnResult queryCatalog(@RequestParam String uid,
                              @RequestParam String sid) {

        List a = new ArrayList();
        a.add("1");
        a.add("2");
        a.add("3");

        return ReturnResult.success(a);
    }

}
