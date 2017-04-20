package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DynaSqlProvider2 {

	//使用字符串拼接的方法构建SQL语句是非常困难的，并且容易出错。所以MyBaits提供了一个SQL工具类不使用字符串拼接的方式，简化构造动态SQL语句。
	public String findQuetionByIdSql(final @Param("questionID") int questionID) {
		return new SQL() {
			{
				SELECT("questionID, content");
				FROM("qz_question");
				WHERE("questionID=" + questionID);
			}
		}.toString();
	}

	//如果映射器Mapper接口有多个输入参数，我们可以使用参数类型为java.util.Map的方法作为SQLprovider方法。
	//然后映射器Mapper接口方法所有的输入参数将会被放到map中，以param1,param2等等作为key，将输入参数按序作为value。
	//你也可以使用0，1，2等作为key值来取的输入参数。
	public String findCityByNameAndCountry(Map<String, Object> map) {
	    String name = (String) map.get("param1");
	    String country = (String) map.get("param2");
	    //you can also get those values using 0,1 keys
	    //String name = (String) map.get("arg0");
	    //String email = (String) map.get("arg1");
	    return new SQL()
	    {
	        {
	            SELECT("id, name, country");
	            FROM("city");
	            WHERE("name=#{name} AND country=#{country}");
	        }
	    } .toString();
	}

	//SQL工具类也提供了其他的方法来表示JOINS，ORDER_BY，GROUP_BY等等。
	public String selectTutorById() {
        return new SQL()
        {
            {
                SELECT("t.tutor_id, t.name as tutor_name, email");
                SELECT("a.addr_id, street, city, state, zip, country");
                SELECT("course_id, c.name as course_name, description, start_date, end_date");
                FROM("TUTORS t");
                LEFT_OUTER_JOIN("addresses a on t.addr_id=a.addr_id");
                LEFT_OUTER_JOIN("courses c on t.tutor_id=c.tutor_id");
                WHERE("t.TUTOR_ID = #{id}");
            }
        } .toString();
    }

}
