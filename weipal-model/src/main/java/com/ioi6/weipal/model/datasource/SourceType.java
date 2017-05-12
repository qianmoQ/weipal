package com.ioi6.weipal.model.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * source type
 * Created by shicheng on 2017/5/12.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SourceType {

    private Integer id;
    private String typeName;
    private String typeCode;
    private Boolean enable;
    private Date createTime;
    private Date updateTime;

}
