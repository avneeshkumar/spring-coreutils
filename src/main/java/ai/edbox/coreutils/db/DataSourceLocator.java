package ai.edbox.coreutils.db;

import javax.naming.NameNotFoundException;

import org.apache.tomcat.jdbc.pool.DataSource;

import ai.edbox.coreutils.constants.TomcatConstants;
import ai.edbox.coreutils.utils.LogUtils;
import ai.edbox.tomcat_ds.PooledDataSourceFactory;

public class DataSourceLocator {
	public DataSource getEdboxMasterDs() {
        DataSource ds = null;
        try {
               ds = PooledDataSourceFactory.getDataSource(TomcatConstants.DATASOURCE_EDBOXMASTER);
        } catch (NameNotFoundException e) {
               LogUtils.error(DataSourceLocator.class, e.getMessage(), e);
        }
        return ds;
	}
}
