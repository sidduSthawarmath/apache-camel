package com.siddu.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SimpleFileProcessor implements Processor {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("START SampleProcessor:" + simpleDateFormat.format(new Date()));
		System.out.println(exchange.getIn().getBody(String.class));
		System.out.println("END SampleProcessor");
	}

}
