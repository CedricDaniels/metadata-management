package com.cdeledu.datahub.metadata.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatisSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSampleApplication.class, args);
    }

    private final CityMapper cityMapper;

    public MybatisSampleApplication(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Bean
    CommandLineRunner sampleCommandLineRunner() {
    	//System.out.println(this.cityMapper.findAll());
    	//System.out.println(this.cityMapper.findByState("CA"));
    	System.out.println(this.cityMapper.likeName("San Francisco"));

    	//System.out.println(this.cityMapper.delete((long)3));

    	//City city = new City();
    	//city.setId((long)2);
    	//city.setName("北京");
    	//System.out.println(this.cityMapper.update(city));

    	//this.cityMapper.insert("beijing", "beijing", "china");
    	//City city = new City();
    	//city.setName("南京");
    	//city.setState("江苏");
    	//city.setCountry("中国");
    	//this.cityMapper.insertByDomain(city);
    	//System.out.println(city.getId());

    	//System.out.println(this.cityMapper.selectQuestionWithQuestionID(11122945));
    	//System.out.println(this.cityMapper.selectQuestionWithQuestionID2(11122945));
    	//System.out.println(this.cityMapper.findQuestionById(11122945));
    	//System.out.println(this.cityMapper.findQuestionById2(11122945));
    	//System.out.println(this.cityMapper.findCityByNameAndCountry("北京", "china"));

    	//City city = new City();
    	//city.setName("南京1");
    	//city.setCountry("中国");
    	//this.cityMapper.insertCity(city);

    	//List<City> citys = new ArrayList<>();
    	//City city = new City();
    	//city.setName("南京2");
    	//city.setCountry("中国");
    	//citys.add(city);
    	//City city1 = new City();
    	//city1.setName("南京3");
    	//city1.setCountry("中国");
    	//citys.add(city1);
    	//this.cityMapper.insertCitys(citys);

    	//City city = new City();
    	//city.setId((long)2);
    	//city.setName("北京1");
    	//this.cityMapper.updateCity(city);

    	//this.cityMapper.deleteCity(6);

        return null;
    }

}