package com.ioi6.weipal.database.datasource;

import com.ioi6.weipal.database.datasource.mapper.DataSourceMapper;
import com.ioi6.weipal.model.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shicheng on 2017/5/12.
 */
@Service(value = "dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public List<DataSource> getAllSource() {
        return dataSourceMapper.getAllSource();
    }

    @Override
    public List<DataSource> getAllSourceByUserId(String createUserId) {
        return dataSourceMapper.getAllSourceByUserId(createUserId);
    }
}
