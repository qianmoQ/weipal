package com.ioi6.weipal.server.controller.datasource;

import com.ioi6.weipal.model.result.ReturnResult;
import com.ioi6.weipal.server.param.DataSourceParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * datasource controller
 * Created by shicheng on 2017/5/12.
 */
@RestController
@RequestMapping(value = "/api/${weipal.api.version}/datasource")
@Slf4j
public class DataSourceController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ReturnResult createSource(@RequestBody DataSourceParam dataSource) {
        return ReturnResult.failure();
    }

}
