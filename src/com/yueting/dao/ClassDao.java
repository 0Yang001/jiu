package com.yueting.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yueting.model.Class;
import com.yueting.model.Company;
import com.yueting.model.Student;
@Repository("ClassDao")
public interface ClassDao {
	//根据班级名字查询
	public List<Class> getByName(Map<String, Object> map);
	//根据Id查询
	public Class getById(int id);
	//根据id修改班级信息
	public void updateById(Class c);
	//根据id删除班级信息
	public void deleteById(int id);
	//添加班级信息
	public void addClass(Class c);
	//查询班级的数目
	public int getCountClass();
	//查找全部班级
	public List<Class> getAllClass(Map<String, Object> map);
	//获取全部班级
	public  List<Class> getAll();
	
}
