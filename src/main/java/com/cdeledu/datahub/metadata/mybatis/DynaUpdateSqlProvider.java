package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.jdbc.SQL;

public class DynaUpdateSqlProvider {

	public String updateCity(final City city) {
		return new SQL()
        {
            {
                UPDATE("city");
                if (city.getName() != null)
                {
                    SET("name = #{name}");
                }
                if (city.getCountry() != null)
                {
                    SET("country = #{country}");
                }
                WHERE("id = #{id}");
            }
        } .toString();
    }

}
