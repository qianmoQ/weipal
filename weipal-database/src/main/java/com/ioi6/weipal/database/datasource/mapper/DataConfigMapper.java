package com.ioi6.weipal.database.datasource.mapper;

import com.ioi6.weipal.model.datasource.SourceConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * data config mapper
 * Created by shicheng on 2017/5/14.
 */
public interface DataConfigMapper {

    /**
     * get datasource all config
     *
     * @param createUserId user id
     * @param datasourceId source id
     * @return all config
     */
    @Select(value = "SELECT configName , configValue FROM datasource AS ds " +
            "LEFT JOIN sourcetype AS st ON ds.sourceTypeId = st.id " +
            "LEFT JOIN sourceconfig AS sc ON sc.sourceTypeId = st.id " +
            "WHERE ds.createUserId = #{createUserId}' AND ds.id = #{datasourceId}")
    List<SourceConfig> getAllConfigByUidAndSid(String createUserId, String datasourceId);

}
