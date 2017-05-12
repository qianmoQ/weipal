package com.ioi6.weipal.model.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * data source model
 * Created by shicheng on 2017/5/12.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataSource {

    private Integer id;
    private String sourceName;
    private String sourceCode;
    private String createUserId;
    private String sourceTypeId;
    private Boolean enable;
    private Date createTime;
    private Date updateTime;

}
