/*package com.studentapp.junit.studentsInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)

public class FirstSerenityTest {
   
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);		
		
	}
	
	@Test
	public void failedTestCase() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.statusCode(500);
		
	}
	
	@Pending
	@Test
	public void pendingCase() {
	
	}
	
	@Ignore
	@Test
	public void ignoreCase() {
	
	}
	
	@Test
	public void failedCase() {
		
		System.out.println("Error occured"+ (1/0));
		
	}
	
	@Test
	public void fileFinder() throws FileNotFoundException {
		
		File a=new File("E://file.txt");
		FileReader fr=new FileReader(a);
		System.out.println(fr);
	}
	
	@Manual
	@Test
	public void manualTest()  {
		
	}
	
		
}
