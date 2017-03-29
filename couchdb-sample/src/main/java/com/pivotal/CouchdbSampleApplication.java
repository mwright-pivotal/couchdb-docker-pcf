package com.pivotal;

import org.lightcouch.CouchDbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CouchdbSampleApplication {

	@Autowired
	private CouchDbClient myDB;

	public static void main(String[] args) {
		SpringApplication.run(CouchdbSampleApplication.class, args);
	}

	@RequestMapping(path = "/")
	public DBInfo list() {
		RestTemplate restTemplate = new RestTemplate();
		DBInfo dbInfo = restTemplate.getForObject("http://couchdb.cf.wrightcode.net/alice", DBInfo.class);

		return dbInfo;
	}

	@Bean
	public CouchDbClient myCouchClient() {
		CouchDbClient dbClient = new CouchDbClient("application.properties");

		return dbClient;
	}
}
