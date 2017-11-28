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
package com.ioi6.weipal.model.result;

import com.ioi6.weipal.model.auxiliary.StatusAuxiliary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * data return model
 * Created by shicheng on 2016/12/14.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResult {

    private String code; // status 0000 success, 1111 failure
    private Object data; // return data

    public static ReturnResult success() {
        return new ReturnResult(StatusAuxiliary.SUCCESS.value(), StatusAuxiliary.SUCCESS_MSG.value());
    }

    public static ReturnResult success(Object data) {
        return new ReturnResult(StatusAuxiliary.SUCCESS.value(), data);
    }

    public static ReturnResult success(String code, Object data) {
        return new ReturnResult(code, data);
    }

    public static ReturnResult failure() {
        return new ReturnResult(StatusAuxiliary.FAILURE.value(), StatusAuxiliary.FAILURE_MSG.value());
    }

    public static ReturnResult failure(Object data) {
        return new ReturnResult(StatusAuxiliary.FAILURE.value(), data);
    }

    public static ReturnResult failure(String code, Object data) {
        return new ReturnResult(code, data);
    }

    public static ReturnResult empty() {
        return new ReturnResult(StatusAuxiliary.EMPTY.value(), StatusAuxiliary.EMPTY_MSG.value());
    }

    public static ReturnResult empty(Object data) {
        return new ReturnResult(StatusAuxiliary.EMPTY.value(), data);
    }

    public static ReturnResult empty(String code, Object data) {
        return new ReturnResult(code, data);
    }

}
