package com.yueting.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.yueting.dao.JiuyeDao;
import com.yueting.dao.StudentDao;
import com.yueting.model.Company;
import com.yueting.model.Jiuye;
import com.yueting.service.CompanyService;
import com.yueting.service.JiuyeService;
@Service("JiuyeServiceImpl")
public class JiuyeServiceImpl implements JiuyeService{
	@Resource(name="JiuyeDao")
	private JiuyeDao jd ;

	public JiuyeDao getJd() {
		return jd;
	}

	public void setJd(JiuyeDao jd) {
		this.jd = jd;
	}

	@Override
	public void addJiuye(Jiuye y) {
		jd.addJiuye(y);
		
	}

	@Override
	public List<Jiuye> searchByClass(String classname) {
		// TODO Auto-generated method stub
		return jd.searchByClass(classname);
	}

	@Override
	public void deleteJiuye(int comid) {
		// TODO Auto-generated method stub
		jd.deleteJiuye(comid);
	}

	@Override
	public int getCountJiuye() {
		// TODO Auto-generated method stub
		return jd.getCountJiuye();
	}

	@Override
	public List<Jiuye> getAllJiuye(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jd.getAllJiuye(map);
	}

	@Override
	public List<Jiuye> geyAllByClassId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jd.geyAllByClassId(map);
	}

	@Override
	public void deleteBySid(int sid) {
		jd.deleteBySid(sid);
		
	}
	
}
