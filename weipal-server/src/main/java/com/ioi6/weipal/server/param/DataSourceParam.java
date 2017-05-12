package com.ioi6.weipal.server.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by shicheng on 2017/5/12.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceParam {

    private String sourceName;
    private String sourceCode;
    private String createUserId;
    private String sourceTypeId;

}
