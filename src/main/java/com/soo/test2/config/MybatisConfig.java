package com.soo.test2.config;

import javax.sql.DataSource;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//@Configuration
@MapperScan("com.soo.test2.dao")
public class MybatisConfig {
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext appCtx) throws Exception {

    // Mybatis의 Log4j2를 활성화시키기 
    LogFactory.useLog4J2Logging();
    
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.soo.test2.domain");
    sqlSessionFactoryBean.setMapperLocations(
        appCtx.getResources("classpath:com/soo/test2/mapper/*Mapper.xml"));
    
    return sqlSessionFactoryBean.getObject();
  }
}






