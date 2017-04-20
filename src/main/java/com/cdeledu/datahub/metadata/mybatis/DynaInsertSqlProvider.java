package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class DynaInsertSqlProvider {

	public String insertCity(final City city) {
        return new SQL()
        {
            {
                INSERT_INTO("city");
                if (city.getName() != null)
                {
                    VALUES("name", "#{name}");
                }
                if (city.getCountry() != null)
                {
                    VALUES("country", "#{country}");
                }
            }
        } .toString();
    }

	public String insertCitys(@Param("citys") List<City> citys) {
		String str = "";
		for (City city : citys) {
			str += "insert into city (name, country) values ('"+city.getName()+"', '"+city.getCountry()+"');";
		}
		return str;
	}

}
