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
package com.ioi6.weipal.server.controller.formatter;

import com.facebook.presto.sql.SqlFormatter;
import com.facebook.presto.sql.parser.SqlParser;
import com.facebook.presto.sql.tree.Statement;
import com.ioi6.weipal.common.constant.System;
import com.ioi6.weipal.model.result.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * sql formatter
 * Created by shicheng on 2017/5/12.
 */
@RestController
@RequestMapping(value = "/api/${weipal.api.version}/formatter/sql")
@Slf4j
public class SqlController {

    @RequestMapping(value = "format", method = RequestMethod.POST)
    ReturnResult formatter(@RequestParam String sql) {
        if (StringUtils.isNotEmpty(sql)) {
            try {
                log.info("formart sql is {}", sql);
                SqlParser parser = new SqlParser();
                Statement statement = parser.createStatement(sql);
                String formatSql = SqlFormatter.formatSql(statement, Optional.empty());
                return ReturnResult.success(formatSql);
            } catch (Exception e) {
                log.error("error sql {} \nformatter sql error {}", sql, e);
                return ReturnResult.failure(System.SQL_ERROR);
            }
        }
        return ReturnResult.empty();
    }

}
