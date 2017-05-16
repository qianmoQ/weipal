package com.ioi6.weipal.database.datasource.mapper;

import com.ioi6.weipal.model.datasource.DataSource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * datasource mapper
 * Created by shicheng on 2017/5/12.
 */
public interface DataSourceMapper {

    @Select(value = "SELECT id, sourceName , sourceCode , createUserId , enable , sourceTypeId , createTime , updateTime FROM datasource")
    List<DataSource> getAllSource();

    @Select(value = "SELECT id, sourceName , sourceCode , createUserId , enable , sourceTypeId , createTime , updateTime FROM datasource " +
            "WHERE createUserId = #{createUserId}")
    List<DataSource> getAllSourceByUserId(String createUserId);

}
