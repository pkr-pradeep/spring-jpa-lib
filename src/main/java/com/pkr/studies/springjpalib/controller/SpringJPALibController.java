package com.pkr.studies.springjpalib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.studies.springjpalib.bean.School;
import com.pkr.studies.springjpalib.service.ProcessMessage;

@RestController
@RequestMapping("/app")
public class SpringJPALibController {

	private static final String PKR_STUDIES = "PKR Studies";
	@Autowired
	ProcessMessage processMessage;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Hello Welcome to Spring JPA Library";
	}

	/**
	 * http://localhost:8080/app/getSchoolData?name=Prasanna&roll=2&std=24
	 * 
	 * @param studentName
	 * @param roll
	 * @param stdId
	 * @return
	 */
	@RequestMapping(value = "/getSchoolData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<School>> getSchoolData(@RequestParam("name") String studentName,
			@RequestParam("roll") String roll, @RequestParam("std") Integer stdId) {
		School school = new School(stdId, studentName, roll, null, '\0');
		List<School> schoolDataList = processMessage.getAllSchoolData(school);
		return new ResponseEntity<List<School>>(schoolDataList, HttpStatus.OK);
	}

	/**
	 * http://localhost:8080/app/saveSchool?name=Prasanna&roll=2&std=24&grade=A
	 * 
	 * @param studentName
	 * @param roll
	 * @param stdId
	 * @param grade
	 * @return
	 */
	@RequestMapping(value = "/saveSchool", method = RequestMethod.POST)
	public ResponseEntity<String> saveSchool(@RequestParam("name") String studentName,
			@RequestParam("roll") String roll, @RequestParam("std") Integer stdId, @RequestParam("grade") char grade) {
		School school = new School();
		school.setSCHOOL_NM(PKR_STUDIES);
		school.setSTD_NM(studentName);
		school.setROLL_NM(roll);
		school.setSTD_ID(stdId);
		school.setGRADE(grade);

		processMessage.save(school);
		return new ResponseEntity<String>("Done", HttpStatus.OK);
	}

	/**
	 * 
	 * @param newName
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "/updateSchool", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSchoolData(@RequestParam("name") String newName, @RequestBody School school) {
		processMessage.update(newName, school);
		return new ResponseEntity<String>("Done", HttpStatus.OK);
	}
}