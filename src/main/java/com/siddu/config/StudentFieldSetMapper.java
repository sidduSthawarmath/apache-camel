package com.siddu.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentFieldSetMapper {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");

	public List<Student> process(List<List> csvRows) {
		List<Student> studentList = new ArrayList<>();
		for (List csvRow : csvRows) {
			Student student = new Student();
			student.setFirstName(csvRow.get(0).toString());
			student.setLastName(csvRow.get(1).toString());
			student.setPhoneNumber(csvRow.get(2).toString());
			student.setUpdatedTimeStamp(simpleDateFormat.format(new Date()));
			studentList.add(student);
		}
		return studentList;
	}

	public Map<String, Object> dataMapper(List<List> csvRows) {
		Map<String, Object> studentList = new HashMap<String, Object>();
		for (List csvRow : csvRows) {

			Map<String, Object> answer = new HashMap<String, Object>();
			answer.put("first_name", csvRow.get(0).toString());
			answer.put("last_name", csvRow.get(1).toString());
			answer.put("phone_num", csvRow.get(2).toString());
			answer.put("updated_time_stamp", simpleDateFormat.format(new Date()));

			studentList.putAll(answer);
		}
		return studentList;
	}

}
