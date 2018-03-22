package com.yueting.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yueting.model.Class;
import com.yueting.model.Jiuye;
@Repository("JiuyeDao")
public interface JiuyeDao {
	//添加就业信息
	public void addJiuye(Jiuye y);
	//根据班级查询
	public List<Jiuye> searchByClass(String classname);
	//根据企业id删除就业信息
	public void deleteJiuye(int comid);
	//查询就业信息的数目
	public int getCountJiuye();
	//查询所有的就业信息
	public List<Jiuye> getAllJiuye(Map<String, Object> map);
	//根据班级id查询所有的就业信息
	public List<Jiuye> geyAllByClassId(Map<String, Object> map);
	//根据学生id删除就业信息
	public void deleteBySid(int sid);
	
}
