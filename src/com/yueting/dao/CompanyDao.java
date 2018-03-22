package com.yueting.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yueting.model.Class;
import com.yueting.model.Company;
@Repository("CompanyDao")
public interface CompanyDao {
	//添加企业信息
	public void addCom(Company c);
	//根据名字查找企业
	public List<Company> searchComByName(Map<String, Object> map);
	//编辑企业信息
	public void updataComByid(Company c);
	//删除企业信息
	public void deleteComByid(int id);
	//根据招聘状态已经结束
	public List<Company> getComByend(Map<String, Object> map);
	//还在招聘中
	public List<Company> getComByhold(Map<String, Object> map);
	//根据id查找企业
	public Company getComById(int id);
	//查找全部企业
	public List<Company> getAllCompa(Map<String, Object> map);
	//根据招聘状态查询企业
	public List<Company> getAllByZhuang(Map<String, Object> map);
	//按计划的时间排序
	public List<Company> getAllByJihua(Map<String, Object> map);
	//按实际的时间排序
	public List<Company> getAllByShiji(Map<String, Object> map);
	//查询企业的数目
	public int getCountComp();
}
