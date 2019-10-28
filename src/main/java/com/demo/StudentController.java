package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@GetMapping(produces = "application/json")
	public String getStudent() {
		System.out.println("Inside method getStudent()");
		return "{\"name\":\"Test Student 1\",\"age\":20}";
	}

	@GetMapping(path = "/id", produces = "application/json")
	public String getStudentById() {
		System.out.println("Inside method getStudentById()");
		return "{\"name\":\"Test Student 2\",\"age\":22}";
	}

	@GetMapping(path = "/exc", produces = "application/json")
	public String exceptionCase() throws Exception {
		System.out.println("Inside method exceptionCase()");
		throw new Exception("Exception thrown!");
	}

}
