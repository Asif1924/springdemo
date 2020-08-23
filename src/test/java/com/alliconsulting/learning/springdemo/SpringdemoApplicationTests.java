package com.alliconsulting.learning.springdemo;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alliconsulting.learning.springdemo.model.Person;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringdemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void someTest(){
		List<Person> someDB = new ArrayList<>();
		Person p1 = new Person(UUID.fromString("d169c4a0-af64-11ea-b3de-0242ac130004"),"Asif");
		Person p2 = new Person(UUID.fromString("da3ffb30-af64-11ea-b3de-0242ac130004"),"Bob");

		someDB.add(p1);
		someDB.add(p2);

		Person search = new Person(UUID.fromString("d169c4a0-af64-11ea-b3de-0242ac130004"),"Asif");
		int indexFound = someDB.indexOf(search);
		Assert.isTrue(!(someDB.indexOf(search)>0));



	}

}
