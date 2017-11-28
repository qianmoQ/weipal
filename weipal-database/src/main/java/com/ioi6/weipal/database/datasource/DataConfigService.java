package com.ioi6.weipal.database.datasource;

import com.ioi6.weipal.model.datasource.SourceConfig;

import java.util.List;

/**
 * data config mapper
 * Created by shicheng on 2017/5/14.
 */
public interface DataConfigService {

    /**
     * get datasource all config
     *
     * @param createUserId user id
     * @param datasourceId source id
     * @return all config
     */
    List<SourceConfig> getAllConfigByUidAndSid(String createUserId, String datasourceId);

}
