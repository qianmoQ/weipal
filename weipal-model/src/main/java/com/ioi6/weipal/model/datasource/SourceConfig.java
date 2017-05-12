package com.ioi6.weipal.model.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 *
 * Created by shicheng on 2017/5/12.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SourceConfig {

    private Integer id;
    private String configName;
    private String configValue;
    private String sourceTypeId;
    private Boolean enable;
    private Date createTime;
    private Date updateTime;

}
