package com.yueting.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueting.dao.CompanyDao;
import com.yueting.model.Class;
import com.yueting.model.Company;
import com.yueting.service.ClassService;
import com.yueting.service.CompanyService;
@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService{
	@Resource(name="CompanyDao")
	private CompanyDao sd ;
	
	public CompanyDao getSd() {
		return sd;
	}

	public void setSd(CompanyDao sd) {
		this.sd = sd;
	}

	@Override
	public void addCom(Company c) {
		// TODO Auto-generated method stub
		sd.addCom(c);
	}

	@Override
	public List<Company> searchComByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.searchComByName(map);
	}

	@Override
	public void updataComByid(Company c) {
		// TODO Auto-generated method stub
		sd.updataComByid(c);
	}

	@Override
	public void deleteComByid(int id) {
		// TODO Auto-generated method stub
		sd.deleteComByid(id);
	}

	@Override
	public List<Company> getComByend(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getComByend(map);
	}

	@Override
	public List<Company> getComByhold(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getComByhold(map);
	}

	@Override
	public Company getComById(int id) {
		// TODO Auto-generated method stub
		return sd.getComById(id);
	}

	@Override
	public List<Company> getAllCompa(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getAllCompa(map);
	}

	@Override
	public List<Company> getAllByZhuang(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getAllByZhuang(map);
	}

	@Override
	public List<Company> getAllByJihua(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getAllByJihua(map);
	}

	@Override
	public List<Company> getAllByShiji(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sd.getAllByShiji(map);
	}

	@Override
	public int getCountComp() {
		// TODO Auto-generated method stub
		return sd.getCountComp();
	}
	

}
