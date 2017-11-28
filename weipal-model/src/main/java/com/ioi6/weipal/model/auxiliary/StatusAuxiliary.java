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
package com.ioi6.weipal.model.auxiliary;

/**
 * status model
 * Created by shicheng on 2016/12/14.
 */
public enum StatusAuxiliary {

    SUCCESS("0000"),
    SUCCESS_MSG("success"),

    FAILURE("1111"),
    FAILURE_MSG("failure"),

    EMPTY("0001"), // 空状态吗
    EMPTY_MSG("data is empty"), // 空提示信息
    ;

    private String value;

    StatusAuxiliary(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
