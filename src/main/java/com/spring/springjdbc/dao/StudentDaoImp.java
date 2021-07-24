package com.spring.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImp implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		// TODO Auto-generated method stub	
		
		  //insert query
        String query="insert into student (id, name, city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public int change(Student student) {
		// TODO Auto-generated method stub
		String query = "update student set name=? , city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
		
		
	}
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		String query="delete from student where id = ?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}
	
	public Student getStudent(int studentId) {
		
		
		// TODO Auto-generated method stub
		String query="select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
		
	}
	
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> r = this.jdbcTemplate.query(query, rowMapper);
		return r;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	

}
