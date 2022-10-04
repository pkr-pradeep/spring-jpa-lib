package com.pkr.studies.springjpalib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkr.studies.springjpalib.bean.School;
import com.pkr.studies.springjpalib.dao.ISchoolDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProcessMessage {

	@Autowired
	ISchoolDao iSchoolDao;

	public void save(School school) {
		iSchoolDao.insertSchoolData(school);
		log.info("inserted successfully" + school.toString());
	}

	public void update(String newName, School school) {
		iSchoolDao.updateStudentName(newName, school);
		log.info("inserted successfully" + school.toString());
	}

}