package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class DynaDeleteSqlProvider {

	public String deleteCity(final @Param("id") long id) {
		return new SQL()
        {
            {
            	DELETE_FROM("city");
                WHERE("id = #{id}");
            }
        } .toString();
    }

}
