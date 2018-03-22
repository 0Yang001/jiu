package com.yueting.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueting.dao.ClassDao;
import com.yueting.dao.StudentDao;
import com.yueting.model.Student;
import com.yueting.service.StudentService;
@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService{
	@Resource(name="StudentDao")
	private StudentDao sd ;

	public StudentDao getSd() {
		return sd;
	}

	public void setSd(StudentDao sd) {
		this.sd = sd;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return sd.getStudentById(id);
	}

	@Override
	public List<Student> getStudentByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getStudentByName(map);
	}

	@Override
	public List<Student> getByClassid(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getByClassid(map);
	}

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		sd.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		sd.updateStudent(s);
	}

	@Override
	public void deleteStudentByClassId(int classid) {
		sd.deleteStudentByClassId(classid);
		
	}

	@Override
	public int getCountStudent() {
		// TODO Auto-generated method stub
		return sd.getCountStudent();
	}

	@Override
	public List<Student> getStudentAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getStudentAll(map);
	}

	@Override
	public Student getSidByClassid(int classid) {
		// TODO Auto-generated method stub
		return sd.getSidByClassid(classid);
	}
	
}
