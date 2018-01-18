/*package com.studentapp.junit.studentsInfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtil;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)

public class StudentsCRUDTest extends TestBase{
	
	static String firstName= "TestUserFN"+TestUtil.getRandomValue();
	static String lastName= "TestUserLN"+ TestUtil.getRandomValue();
	static String programme= "ComputerScience";
	static String email= TestUtil.getRandomValue()+"xyz@gmail.com";	   
	
	@Title("This test will create a new student")
	@Test
	public void createStudent() {
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		StudentClass student=new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
	    
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
		
		
	}

	@Title("Verify if the student is added into the application")
	@Test
	public void getStudent() {
		
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
}
