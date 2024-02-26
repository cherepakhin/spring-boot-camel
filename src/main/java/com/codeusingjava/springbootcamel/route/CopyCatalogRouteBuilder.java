package com.codeusingjava.springbootcamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CopyCatalogRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:/tmp/testarea/srcDir")
				.to("file:/tmp/testarea/dstDir1")
				.to("file:/tmp/testarea/dstDir2")
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
