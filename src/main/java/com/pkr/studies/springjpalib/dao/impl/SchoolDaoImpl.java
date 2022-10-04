package com.pkr.studies.springjpalib.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.pkr.studies.springjpalib.bean.School;
import com.pkr.studies.springjpalib.dao.ISchoolDao;
import com.pkr.studies.springjpalib.jpa.repository.ISchoolRepository;

@Repository
public class SchoolDaoImpl implements ISchoolDao {

	public static final Logger LOGGER = LoggerFactory.getLogger(SchoolDaoImpl.class);

	@Autowired
	ISchoolRepository iSchoolRepository;
	
	@Override
	public List<School> getAllSchoolData(School school) {
		List<School> schoolDataList = new ArrayList<School>();
		try {
			schoolDataList = iSchoolRepository.findAllSchools(school.getSTD_ID(), school.getSTD_NM(),
					school.getROLL_NM());
		} catch (Exception ex) {
			LOGGER.error(ExceptionUtils.getStackTrace(ex));
		}
		return schoolDataList;
	}

	@Override
	public void insertSchoolData(School school) {
		try {
			List<School> schoolDataList = iSchoolRepository.findAllSchools(school.getSTD_ID(), school.getSTD_NM(),
					school.getROLL_NM());
			if (CollectionUtils.isEmpty(schoolDataList)) {
				iSchoolRepository.save(school);
			}
		} catch (Exception ex) {
			LOGGER.error(ExceptionUtils.getStackTrace(ex));
		}
	}

	@Override
	public void updateStudentName(String newName, School school) {
		try {
			List<School> schoolDataList = iSchoolRepository.findAllSchools(school.getSTD_ID(), school.getSTD_NM(),
					school.getROLL_NM());
			if (!CollectionUtils.isEmpty(schoolDataList)) {
				iSchoolRepository.updateStudentName(newName, school.getSTD_ID(), school.getSTD_NM(),
						school.getROLL_NM());
			}
		} catch (Exception ex) {
			LOGGER.error(ExceptionUtils.getStackTrace(ex));
		}
	}
}