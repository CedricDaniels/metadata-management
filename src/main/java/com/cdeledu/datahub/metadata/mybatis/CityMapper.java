package com.cdeledu.datahub.metadata.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    City findByState(String state);

    //将查询结果通过别名或者是@Results注解与JavaBean属性映射起来
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name")
	})
	@Select("SELECT id, name FROM city")
	List<City> findAll();

    List<City> likeName(String name);

    //使用@ResultMap可以起到共用@Results设置的目的
    @ResultMap("com.cdeledu.datahub.metadata.mybatis.CityMapper.CityResult")
    @Select("SELECT id, name FROM city")
    List<City> findAll2();

    //使用@Update注解的update操作返回值是影响的条数
    @Update("UPDATE city SET name=#{name} WHERE id=#{id}")
    int update(City city);

    //使用@Delete注解的delete操作返回值是删除的条数
    @Delete("DELETE FROM city WHERE id =#{id}")
    int delete(long id);

    @Insert("INSERT INTO city(name, state, country) VALUES(#{name}, #{state}, #{country})")
    //返回自增长主键，存入id字段
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertByDomain(City city);

    @Insert("insert into city(name, state, country) values(#{name}, #{state}, #{country})")
    public int insert(@Param("name") String name, @Param("state") String state, @Param("country") String country);

    //一对一、一对多
    @Select("SELECT videoID, cwID FROM QZ_QUESTION_VIDEO WHERE questionID=#{questionID}")
    Video findVideoById(int questionID);
    @Select("SELECT quesOption, quesValue FROM qz_question_option WHERE questionID=#{questionID}")
    List<Option> findOptionById(int questionID);
    @Select("SELECT questionID, content FROM qz_question WHERE questionID=#{questionID} ")
    @Results(
    {
        @Result(id = true, column = "questionID", property = "questionID"),
        @Result(column = "content", property = "content"),
        @Result(property = "video", column = "questionID",
        		one = @One(select = "com.cdeledu.datahub.metadata.mybatis.CityMapper.findVideoById")),
        @Result(property = "option", column = "questionID",
        		many  = @Many (select = "com.cdeledu.datahub.metadata.mybatis.CityMapper.findOptionById"))
    })
    Question selectQuestionWithQuestionID(int questionID);

    @Select("SELECT a.questionID, a.content, b.videoID, b.cwID, c.quesOption, c.quesValue "
    		+ "FROM qz_question a, QZ_QUESTION_VIDEO b, qz_question_option c "
    		+ "WHERE a.questionID=b.questionID and a.questionID=c.questionID and a.questionID=#{questionID} ")
    @ResultMap("com.cdeledu.datahub.metadata.mybatis.CityMapper.QuestionResult")
    Question selectQuestionWithQuestionID2(int questionID);

    //这里我们使用了@SelectProvider来指定了一个类，及其内部的方法，用来提供需要执行的SQL语句。
    @SelectProvider(type=DynaSqlProvider.class, method="findQuetionByIdSql")
    Question findQuestionById(@Param("questionID") int questionID);
    @SelectProvider(type=DynaSqlProvider2.class, method="findQuetionByIdSql")
    Question findQuestionById2(@Param("questionID") int questionID);
    @SelectProvider(type=DynaSqlProvider2.class, method="findCityByNameAndCountry")
    City findCityByNameAndCountry(@Param("name") String name, @Param("country") String country);

    @InsertProvider(type = DynaInsertSqlProvider.class, method = "insertCity")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCity(City city);

    @InsertProvider(type = DynaInsertSqlProvider.class, method = "insertCitys")
    int insertCitys(@Param("citys") List<City> citys);

    @UpdateProvider(type = DynaUpdateSqlProvider.class, method = "updateCity")
    int updateCity(City city);

    @DeleteProvider(type = DynaDeleteSqlProvider.class, method = "deleteCity")
    int deleteCity(@Param("id") long id);

}