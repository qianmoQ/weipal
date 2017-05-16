package com.ioi6.weipal.database.datasource;

import com.ioi6.weipal.model.datasource.DataSource;

import java.util.List;

/**
 * data source service
 * Created by shicheng on 2017/5/12.
 */
public interface DataSourceService {

    List<DataSource> getAllSource();

    List<DataSource> getAllSourceByUserId(String createUserId);

}
