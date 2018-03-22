package com.yueting.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yueting.model.Class;
import com.yueting.model.Student;
public interface StudentService {
		//根据ID查找学生
		public Student getStudentById(int id);
		//根据名字查找学生
		public List<Student> getStudentByName(Map<String, Object> map);
		//根据班级id查找学生
		public List<Student> getByClassid(Map<String, Object> map);
		//添加学生信息
		public void addStudent(Student s);
		//删除学生信息根据id
		public void deleteStudent(int id);
		//根据id更改学生信息
		public void updateStudent(Student s);
		//根据班级的id删除学生信息
		public void deleteStudentByClassId(int classid);
		//查询所有学生的数目
		public int getCountStudent();
		//查询所有的学生
		public List<Student> getStudentAll(Map<String, Object> map);
		//根据classid查询学生的id
		public Student getSidByClassid(int classid);
}
