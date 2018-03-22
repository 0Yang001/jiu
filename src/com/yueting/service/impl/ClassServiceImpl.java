package com.yueting.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueting.dao.ClassDao;
import com.yueting.model.Class;
import com.yueting.model.Student;
import com.yueting.service.ClassService;
@Service("ClassServiceImpl")
public class ClassServiceImpl implements ClassService{
	@Resource(name="ClassDao")
	private ClassDao sd;

	public ClassDao getSd() {
		return sd;
	}

	public void setSd(ClassDao sd) {
		this.sd = sd;
	}

	@Override
	public List<Class> getByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getByName(map);
	}

	@Override
	public Class getById(int id) {
		// TODO Auto-generated method stub
		return sd.getById(id);
	}

	@Override
	public void updateById(Class c) {
		// TODO Auto-generated method stub
		sd.updateById(c);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sd.deleteById(id);
	}

	@Override
	public void addClass(Class c) {
		// TODO Auto-generated method stub
		sd.addClass(c);
	}

	@Override
	public int getCountClass() {
		// TODO Auto-generated method stub
		return sd.getCountClass();
	}

	@Override
	public List<Class> getAllClass(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getAllClass(map);
	}

	@Override
	public List<Class> getAll() {
		// TODO Auto-generated method stub
		return sd.getAll();
	}
	
}
