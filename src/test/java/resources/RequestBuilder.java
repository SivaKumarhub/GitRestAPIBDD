package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import Utils.GetProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
	public static RequestSpecification req;
	GetProperties prop = new GetProperties();
  public RequestSpecification request() throws IOException {
	  if(req==null) {
       PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
       req = new RequestSpecBuilder().setBaseUri(prop.getValue("BaseURI")).addQueryParam("key", "qaclick123")
      .addHeader("Content-Type", "application/json")
      .addFilter(RequestLoggingFilter.logRequestTo(log))
      .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
       return req;
	  }
	return req;
  }
}
