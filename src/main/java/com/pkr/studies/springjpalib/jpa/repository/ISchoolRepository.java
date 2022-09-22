package com.pkr.studies.springjpalib.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkr.studies.springjpalib.bean.School;
import com.pkr.studies.springjpalib.bean.primarykey.SchoolCompositeKey;

@Repository
public interface ISchoolRepository extends CrudRepository<School, SchoolCompositeKey>{
	@Query("select s from School s where s.STD_ID=?1 and s.STD_NM=?2 and s.ROLL_NM=?3")
	List<School> findAllSchools(Integer STD_ID, String STD_NM, String ROLL_NM);
}