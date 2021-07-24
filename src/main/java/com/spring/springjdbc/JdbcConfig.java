package com.spring.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.springjdbc.dao.StudentDao;
import com.spring.springjdbc.dao.StudentDaoImp;


@Configuration
@ComponentScan(basePackages = {"com.spring.springjdbc.dao"})
public class JdbcConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
//	
//	@Bean(name= {"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImp studentDao = new StudentDaoImp();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}
}
