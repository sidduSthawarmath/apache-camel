package com.siddu.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CsvFileProcessor implements Processor {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void process(Exchange exchange) throws Exception {
		List<Student> studentList = (List<Student>) exchange.getIn().getBody();
		for (Student student : studentList) {
			// System.out.println(student);

			jdbcTemplate.update("insert into  student (first_name,last_name,phone_num,updated_time_stamp) values('"
					+ student.getFirstName() + "','" + student.getLastName() + "','" + student.getPhoneNumber() + "','"
					+ student.getUpdatedTimeStamp() + "')");
		}

	}

}
