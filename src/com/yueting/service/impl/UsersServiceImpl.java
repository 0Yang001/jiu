package com.yueting.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueting.dao.UsersDao;
import com.yueting.model.Users;
import com.yueting.service.UsersService;
@Service("UsersServiceImpl")
public class UsersServiceImpl implements UsersService{
	@Resource(name="UsersDao")
	private UsersDao ud ;
	
	public UsersDao getUd() {
		return ud;
	}

	public void setUd(UsersDao ud) {
		this.ud = ud;
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return ud.getUserById(id);
	}

	@Override
	public Users Login(Users u) {
		// TODO Auto-generated method stub
		return ud.Login(u);
	}

	@Override
	public void register(Users u) {
		// TODO Auto-generated method stub
		ud.register(u);
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		ud.deleteUserById(id);
	}

	@Override
	public List<Users> searchAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ud.searchAll(map);
	}

	@Override
	public List<Users> searchByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ud.searchByName(map);
	}

	@Override
	public void changePsw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		ud.changePsw(map);
	}

	@Override
	public int getCountUser() {
		// TODO Auto-generated method stub
		return ud.getCountUser();
	}

	@Override
	public void addStudentUser(Users u) {
		ud.addStudentUser(u);
		
	}


}
