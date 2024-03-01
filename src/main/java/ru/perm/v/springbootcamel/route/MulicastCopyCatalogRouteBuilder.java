package ru.perm.v.springbootcamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MulicastCopyCatalogRouteBuilder extends RouteBuilder {
	private String baseDstDir = "file:/tmp/testarea/multicast";
	@Override
	public void configure() throws Exception {
		from("file:/tmp/testarea/multicast/srcDir")
				.multicast().to(baseDstDir+"/dstDir1", baseDstDir+"/dstDir2")
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
