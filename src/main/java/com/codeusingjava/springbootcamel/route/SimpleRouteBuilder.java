package com.codeusingjava.springbootcamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:/home/vasi/temp/testarea/srcDir")
				.to("file:/home/vasi/temp/testarea/dstDir")
				.log("headers: ${headers.CamelFileName}")
				.log("exchange: ${exchange}")
				.log("id: ${id}")
				.log("route id: ${routeId}")
				.log("exchange id: ${exchangeId}")
				.log("body: ${body}")
				.log("headers: ${headers}")
		;
	}
}
