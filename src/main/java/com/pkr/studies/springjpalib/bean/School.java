package com.pkr.studies.springjpalib.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.pkr.studies.springjpalib.bean.primarykey.SchoolCompositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SCHOOL", schema = "PKRSTUDIES")
@IdClass(SchoolCompositeKey.class)
public class School {
	@Id
	public Integer STD_ID;
	@Id
	public String STD_NM;
	@Id
	public String ROLL_NM;
	public String SCHOOL_NM;
	public char GRADE;
}
