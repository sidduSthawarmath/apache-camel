package com.siddu.config;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRouteConfig extends RouteBuilder {

	@Autowired
	private SimpleFileProcessor simpleFileProcessor;

	@Autowired
	private CsvFileProcessor csvFileProcessor;

	@Autowired
	DataSource dataSource;

	@Override
	public void configure() throws Exception {

		/* Reading individual line and writing */

		// consumer.delay=10s -> Delays 1s after file entered into folder
		// idempotent=true -> Avoids duplicate file reading

		from("file:D:/Workspace-own/input/simple-file?noop=true;move=.camel&consumer.delay=1s&idempotent=true")
				.split(body().tokenize("\n")).streaming().process(simpleFileProcessor)
				.to("file:D:/Workspace-own/output");

		// To read csv file and save in db using jdbc template in processor
		from("file:D:/Workspace-own/input/csv-file1?noop=true;move=.camel&consumer.delay=1s&idempotent=true")
				.split(body().tokenize("\n")).streaming().unmarshal().csv().beanRef("studentFieldSetMapper", "process")
				.process(csvFileProcessor);

		// To read csv file and save in db using sql component
		from("file:D:/Workspace-own/input/csv-file?noop=true;move=.camel&consumer.delay=1s&idempotent=true")
				.split(body().tokenize("\n")).streaming().unmarshal().csv()
				.beanRef("studentFieldSetMapper", "dataMapper")
				.to("sql:insert into  student (first_name,last_name,phone_num,updated_time_stamp) values(:#first_name,:#last_name,:#phone_num,:#updated_time_stamp)?dataSource=myDataSource");
	}

}
