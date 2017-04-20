package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.annotations.Param;

//有时候我们需要根据输入条件动态地构建SQL语句。MyBatis提供了各种注解如@InsertProvider,@UpdateProvider,@DeleteProvider和@SelectProvider，来帮助构建动态SQL语句，然后让MyBatis执行这些SQL语句。
public class DynaSqlProvider {

	/**SQL工具类会处理以合适的空格前缀和后缀来构造SQL语句。
	动态SQL provider方法可以接收以下其中一种参数：
	1、无参数
	2、和映射器Mapper接口的方法同类型的参数
	3、java.util.Map
	 * @param questionID
	 * @return
	 */
	public String findQuetionByIdSql(@Param("questionID") int questionID) {
		return "SELECT questionID, content from qz_question WHERE questionID="
				+ questionID;
	}

}
