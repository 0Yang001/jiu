package com.yueting.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutil {
	private static DataSource ds = null;
	static{
		ds = new ComboPooledDataSource();
	}
	public static DataSource getdataSource(){
		return ds;
		
	}
}
