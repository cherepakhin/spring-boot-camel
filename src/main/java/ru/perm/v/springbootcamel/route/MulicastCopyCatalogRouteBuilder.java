package ru.perm.v.springbootcamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MulicastCopyCatalogRouteBuilder extends RouteBuilder {
	private String baseDir = "file:/tmp/testarea/multicast";
	@Override
	public void configure() throws Exception {
		from(baseDir+ "/srcDir")
				.multicast().to(baseDir+"/dstDir1", baseDir+"/dstDir2")
				.log("headers: ${headers.CamelFileName}")
				.log("exchange: ${exchange}")
				.log("id: ${id}")
				.log("route id: ${routeId}")
				.log("exchange id: ${exchangeId}")
//				.log("body: ${body}") // for logging content of files
				.log("headers: ${headers}")
		;
	}
}
