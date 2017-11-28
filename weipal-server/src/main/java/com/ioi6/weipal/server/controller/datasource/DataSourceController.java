/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ioi6.weipal.server.controller.datasource;

import com.ioi6.weipal.database.datasource.DataSourceService;
import com.ioi6.weipal.model.result.ReturnResult;
import com.ioi6.weipal.server.param.DataSourceParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * datasource controller
 * Created by shicheng on 2017/5/12.
 */
@RestController
@RequestMapping(value = "/api/${weipal.api.version}/datasource")
@Slf4j
public class DataSourceController {

    private DataSourceService dataSourceService;

    @Resource(name = "dataSourceService")
    public void setDataSourceService(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ReturnResult createSource(@RequestBody DataSourceParam dataSource) {
        return ReturnResult.failure();
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    ReturnResult getAllSource() {
        return ReturnResult.success(dataSourceService.getAllSource());
    }

    @RequestMapping(value = "get/uid", method = RequestMethod.GET)
    ReturnResult getAllSourceByUserId(@RequestParam String uid) {
        if (StringUtils.isNotEmpty(uid)) {
            return ReturnResult.success(dataSourceService.getAllSourceByUserId(uid));
        }
        return ReturnResult.empty();
    }

}
