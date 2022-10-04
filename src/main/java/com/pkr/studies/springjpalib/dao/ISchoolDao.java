package com.pkr.studies.springjpalib.dao;

import java.util.List;

import com.pkr.studies.springjpalib.bean.School;

public interface ISchoolDao {
	List<School> getAllSchoolData(School school);
	
	void insertSchoolData(School school);

	void updateStudentName(String newName, School school);
}
