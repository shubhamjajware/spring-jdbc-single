package com.codermantra.spring.db;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
		 * StudentDao studentDao = new StudentDao(); studentDao.selectAllrows();
		 * studentDao.deleteAllRows(2);
		 */
		
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		StudentDao studentDao =  context.getBean("studentDao", StudentDao.class);
		studentDao.selectAllrows();

	}

}
