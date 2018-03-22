package com.yueting.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yueting.model.Users;
public interface UsersService {
		//根据id查找用户
		public Users getUserById(int id);
		//用户登录
		public Users Login(Users u);
		//用户的注册
		public void register(Users u);
		//删除用户
		public void deleteUserById(int id);
		//查询所有的用户
		public List<Users> searchAll(Map<String, Object> map);
		//根据用户的名字
		public List<Users> searchByName(Map<String, Object> map);
		//修改密码
		public void changePsw(Map<String, Object> map);
		//查询所有的用户的数目
		public int getCountUser();
		//插入学生用户
		public void addStudentUser(Users u);
}
