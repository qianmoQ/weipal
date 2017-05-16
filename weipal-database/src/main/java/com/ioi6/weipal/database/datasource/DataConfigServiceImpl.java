package com.ioi6.weipal.database.datasource;

import com.ioi6.weipal.database.datasource.mapper.DataConfigMapper;
import com.ioi6.weipal.model.datasource.SourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shicheng on 2017/5/14.
 */
@Service(value = "dataConfigService")
public class DataConfigServiceImpl implements DataConfigService {

    @Autowired
    private DataConfigMapper dataConfigMapper;

    @Override
    public List<SourceConfig> getAllConfigByUidAndSid(String createUserId, String datasourceId) {
        return dataConfigMapper.getAllConfigByUidAndSid(createUserId, datasourceId);
    }

}
