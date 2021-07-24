package com.spring.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.springjdbc.dao.StudentDao;
import com.spring.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //spring jdbc=> JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
      
    StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    //INSERT
//    Student student = new Student();
//    student.setId(455);
//    student.setName("VijayHU");
//    student.setCity("LJN");
//    
//    int insert = studentDao.insert(student);
    
    
//    UPDATE
//    Student student = new Student();
//    student.setCity("Kanpur");
//    student.setName("MAURYA");
//    student.setId(78);
//    int r = studentDao.change(student);
    
    
    //DELETE
//    int r = studentDao.delete(78);
    
    
    //SELECT
//    Student r = studentDao.getStudent(34);
    
//    SELECT ALL
    List<Student> student = studentDao.getAllStudent();
    
    for(Student s: student) {
    	System.out.println(s);
    }
    
//    System.out.println("Student Added"+r);
    
    }
}
