package com.pkr.studies.springjpalib.dao;

import com.pkr.studies.springjpalib.bean.School;

public interface ISchoolDao {
    void insertSchoolData(School school);
    
    void updateStudentName(String newName, School school);
}
