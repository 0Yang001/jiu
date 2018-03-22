package com.yueting.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yueting.model.Class;
import com.yueting.model.Company;
import com.yueting.model.Jiuye;
import com.yueting.model.Student;
import com.yueting.model.Users;
import com.yueting.service.ClassService;
import com.yueting.service.CompanyService;
import com.yueting.service.JiuyeService;
import com.yueting.service.StudentService;
import com.yueting.service.UsersService;
import com.yueting.service.impl.ClassServiceImpl;
import com.yueting.service.impl.CompanyServiceImpl;
import com.yueting.service.impl.JiuyeServiceImpl;
import com.yueting.service.impl.StudentServiceImpl;
import com.yueting.service.impl.UsersServiceImpl;

@Controller
public class IndexController {
	@Resource(name="ClassServiceImpl")
	private ClassServiceImpl classser;
	@Resource(name="CompanyServiceImpl")
	private CompanyServiceImpl commser;
	@Resource(name="JiuyeServiceImpl")
	private JiuyeServiceImpl js;
	@Resource(name="StudentServiceImpl")
	private StudentServiceImpl ss ;
	@Resource(name="UsersServiceImpl")
	private UsersServiceImpl us;
	public ClassServiceImpl getClassser() {
		return classser;
	}
	public void setClassser(ClassServiceImpl classser) {
		this.classser = classser;
	}
	public CompanyServiceImpl getCommser() {
		return commser;
	}
	public void setCommser(CompanyServiceImpl commser) {
		this.commser = commser;
	}
	public JiuyeServiceImpl getJs() {
		return js;
	}
	public void setJs(JiuyeServiceImpl js) {
		this.js = js;
	}
	public StudentServiceImpl getSs() {
		return ss;
	}
	public void setSs(StudentServiceImpl ss) {
		this.ss = ss;
	}
	public UsersServiceImpl getUs() {
		return us;
	}
	public void setUs(UsersServiceImpl us) {
		this.us = us;
	}
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(Users u,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String rememberMe = request.getParameter("rememberMe");
		Users user = us.Login(u);
		if(user != null){
			session.setAttribute("Users", user);
			if(rememberMe !=null && rememberMe.equals("true")){
				Cookie cook = new Cookie(u.getUsername(),u.getPsw());
				cook.setMaxAge(60*60*24);
				response.addCookie(cook);
			}
			
			return "redirect:page/index.jsp";
		}else{
			return "redirect:page/login.jsp";
		}
	}
	@RequestMapping(value="register.do",method=RequestMethod.GET)
	public String register(Users u,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<Class> list =  classser.getAll();
		request.setAttribute("listClass", list);
		return "register";
	}
	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public String register1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username  = request.getParameter("username");
		String  sex = request.getParameter("sex");
		String school  = request.getParameter("school");
		String  major = request.getParameter("major");
		String  biyeshi = request.getParameter("biyeshi");
		String  password = request.getParameter("password");
		String tel  = request.getParameter("tel");
		String qq  = request.getParameter("qq");
		String banji  = request.getParameter("banji");
		Student s = new Student();
		s.setAccount("学生");
		s.setName(username);
		s.setSex(sex);
		s.setSchool(school);
		s.setMajor(major);
		s.setClassid(Integer.parseInt(banji));
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			Date ji = null;
			try {
				ji = sdf.parse(biyeshi);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		s.setGraduate(ji);
		s.setTel(tel);
		s.setQq(qq);
		s.setClassid(Integer.parseInt(banji));
		s.setPsw(password);
		ss.addStudent(s);
		
		
		Users u = new Users();
		u.setAccount("学生");
		u.setPsw(password);
		u.setRole(1);
		u.setUsername(username);
		us.addStudentUser(u);
		
		return "redirect:page/login.jsp";
	}
	@RequestMapping(value="student.do",method=RequestMethod.GET)
	public String student(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int sum = ss.getCountStudent();
		int ye = sum%8==0?sum/8:sum/8+1;
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Student> list  =  ss.getStudentAll(map);
		
		request.setAttribute("pageindex", 1);
		request.setAttribute("pageSum", ye);
		request.setAttribute("listStudent", list);
		

		List<Class> li =  classser.getAll();
		request.setAttribute("listClass", li);
		
		return "student";
	}
	@RequestMapping(value="student.do",method=RequestMethod.POST)
	public String student1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
			String index = request.getParameter("index");
			String ye = request.getParameter("sum");
			
		
			List<Student> list = new ArrayList<Student>();
			Map<String, Object> map = new HashMap<>();
			map.put("pageindex", (Integer.parseInt(index)-1)*8);
			map.put("pagesize", 8);
			list = ss.getStudentAll(map);
			request.setAttribute("listStudent", list);
		
		
		request.setAttribute("pageindex", index);
		request.setAttribute("pageSum", ye);
		List<Class> li = classser.getAll();
		request.setAttribute("listClass", li);
		
		return "student";
	}
	@RequestMapping(value="jiuye.do",method=RequestMethod.GET)
	public String jiuye1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int sum = js.getCountJiuye();
		int ye = sum%8==0?sum/8:sum/8+1;
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Jiuye> list  =  js.getAllJiuye(map);
		
		request.setAttribute("pageindex", 1);
		request.setAttribute("pageSum", ye);
		request.setAttribute("listJiuYe", list);
		

		List<Class> li =  classser.getAll();
		request.setAttribute("listClass", li);
		
		return "test2";
	}
	@RequestMapping(value="jiuye.do",method=RequestMethod.POST)
	public String jiuye(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String index = request.getParameter("index");
		String ye = request.getParameter("sum");
		
		
			List<Jiuye> list = new ArrayList<Jiuye>();
			Map<String, Object> map = new HashMap<>();
			map.put("pageindex", (Integer.parseInt(index)-1)*8);
			map.put("pagesize", 8);
			list = js.getAllJiuye(map);
			request.setAttribute("listJiuYe", list);
		
		
		request.setAttribute("pageindex", index);
		request.setAttribute("pageSum", ye);
		
		List<Class> li =  classser.getAll();
		request.setAttribute("listClass", li);
		
		return "test2";
	}
	@RequestMapping(value="class.do",method=RequestMethod.GET)
	public String classes(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int sum = classser.getCountClass();
		int ye = sum%8==0?sum/8:sum/8+1;
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Class> list  =  classser.getAllClass(map);
		
		request.setAttribute("pageindex", 1);
		request.setAttribute("pageSum", ye);
		request.setAttribute("listClass", list);
		return "class";
	}
	@RequestMapping(value="class.do",method=RequestMethod.POST)
	public String classes1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String index = request.getParameter("index");
		System.out.println(index);
		String ye = request.getParameter("sum");
		String classnamee = request.getParameter("classnamee");
		if(classnamee == null || classnamee.equals("") || classnamee.equals("null")){
			List<Class> list = new ArrayList<Class>();
			Map<String, Object> map = new HashMap<>();
			map.put("pageindex", (Integer.parseInt(index)-1)*8);
			map.put("pagesize", 8);
			list = classser.getAllClass(map);
			request.setAttribute("listClass", list);
		}else{
			Map<String, Object> map1 = new HashMap<>();
			map1.put("classname", classnamee);
			map1.put("pageindex", (Integer.parseInt(index)-1)*8);
			map1.put("pagesize", 8);
			List<Class> lis =  classser.getByName(map1);
			request.setAttribute("listClass", lis);
		}
		request.setAttribute("pageindex", index);
		request.setAttribute("pageSum", ye);
		return "class";
	}
	@RequestMapping(value="testone.do",method=RequestMethod.GET)
	public String testone(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int sum = commser.getCountComp();
		int ye = sum%8==0?sum/8:sum/8+1;
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Company> list =  commser.getAllCompa(map);
		
		request.setAttribute("pageindex", 1);
		request.setAttribute("pageSum", ye);
		request.setAttribute("listCompa", list);
		return "test1";
	}
	@RequestMapping(value="testone.do",method=RequestMethod.POST)
	public String testone1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String index = request.getParameter("index");
		String ye = request.getParameter("sum");
		String commmname = request.getParameter("commmname");
		if(commmname == null || commmname.equals("") || commmname.equals("null")){
			List<Company> list = new ArrayList<Company>();
			Map<String, Object> map = new HashMap<>();
			map.put("pageindex", (Integer.parseInt(index)-1)*8);
			map.put("pagesize", 8);
			list = commser.getAllCompa(map);
			System.out.println(list);
			request.setAttribute("listCompa", list);
		}else{
			Map<String, Object> map1 = new HashMap<>();
			map1.put("comname", commmname);
			map1.put("pageindex", (Integer.parseInt(index)-1)*8);
			map1.put("pagesize", 8);
			System.out.println(map1);
			List<Company> lis =  commser.searchComByName(map1);
			System.out.println(lis);
			request.setAttribute("listCompa", lis);
			
		}
		request.setAttribute("pageindex", index);
		request.setAttribute("pageSum", ye);
		return "test1";
	}
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public String add(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String compname = request.getParameter("compname");
		String jianjie = request.getParameter("jianjie");
		String xuqiu = request.getParameter("xuqiu");
		String address = request.getParameter("address");
		String jitime = request.getParameter("jitime");	
		String shitime = request.getParameter("shitime");
		String cid = request.getParameter("cid");
		Company c = new Company();
		c.setComname(compname);
		c.setJianjie(jianjie);
		c.setXuqiu(xuqiu);
		c.setAddress(address);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			Date ji = null;
			Date shi = null ;
			try {
				ji = sdf.parse(jitime);
				shi = sdf.parse(shitime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			c.setJitime(ji);
			c.setEndtime(shi);
			c.setZhuangtai(cid);
			commser.addCom(c);
		return "redirect:testone.do";
	}
	@RequestMapping(value="addclassone.do",method=RequestMethod.POST)
	public String addclassone(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String classname = request.getParameter("classname");
		String classaddress = request.getParameter("classaddress");
		String kaishi = request.getParameter("kaishi");
		String jieshi = request.getParameter("jieshi");
		Class c = new Class();
		c.setClassname(classname);
		c.setClassadreass(classaddress);
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			Date ji = null;
			Date shi = null ;
			try {
				ji = sdf.parse(kaishi);
				shi = sdf.parse(jieshi);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			c.setStarttime(ji);
			c.setEddtime(shi);
			classser.addClass(c);
		return "redirect:class.do";
	}
	@RequestMapping(value="addjiuye.do",method=RequestMethod.GET)
	public String addjiuye(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 80);
		List<Student> list =  ss.getStudentAll(map);
		request.setAttribute("listStudent", list);
		
		List<Company> lis =  commser.getAllCompa(map);
		request.setAttribute("listComp", lis);
		
		return "addjiuye";
	}
	@RequestMapping(value="addjiuye.do",method=RequestMethod.POST)
	public String addjiuye1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String  gongzi = request.getParameter("gongzi");
		String  jitime = request.getParameter("jitime");
		String  studentname = request.getParameter("studentname");
		String  compname = request.getParameter("compname");
		
		Jiuye y = new Jiuye();
		y.setSalary(gongzi);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date ji = null;
		try {
			ji = sdf.parse(jitime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y.setJiuyetime(ji);
		y.setSid(Integer.parseInt(studentname));
		y.setComid(Integer.parseInt(compname));
		js.addJiuye(y);
		
		return "redirect:jiuye.do";
	}
	@RequestMapping(value="addstudent.do",method=RequestMethod.GET)
	public String addstudent(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Class> list =  classser.getAllClass(map);
		request.setAttribute("listClass", list);
		return "addstudent";
	}
	@RequestMapping(value="addstudent.do",method=RequestMethod.POST)
	public String addstudent1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String studentname = request.getParameter("studentname");
		String studentsex = request.getParameter("studentsex");
		
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String bitime = request.getParameter("bitime");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String banji = request.getParameter("banji");
		
		
		Student s = new Student();
		s.setName(studentname);
		s.setSex(studentsex);
		s.setSchool(school);
		s.setMajor(major);
		s.setPsw("123456789");
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			Date ji = null;
			try {
				ji = sdf.parse(bitime);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		s.setGraduate(ji);
		s.setTel(tel);
		s.setQq(qq);
		s.setClassid(Integer.parseInt(banji));
		
		ss.addStudent(s);
		Users u = new Users();
		u.setUsername(studentname);
		u.setPsw("123456789");
		u.setRole(1);
		u.setAccount("学生");
		us.addStudentUser(u);
		return "redirect:student.do";
	}
	@RequestMapping(value="user.do",method=RequestMethod.GET)
	public String user(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		int sum = us.getCountUser();
		int ye = sum%8==0?sum/8:sum/8+1;
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Users> list  = us.searchAll(map);
		
		request.setAttribute("pageindex", 1);
		request.setAttribute("pageSum", ye);
		request.setAttribute("listUser", list);
		return "users";
	}
	@RequestMapping(value="user.do",method=RequestMethod.POST)
	public String user1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String index = request.getParameter("index");
		System.out.println(index);
		String ye = request.getParameter("sum");
		List<Users> list = new ArrayList<Users>();
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", Integer.parseInt(index));
		map.put("pagesize", 8);
		list = us.searchAll(map);
		request.setAttribute("listUser", list);
		request.setAttribute("pageindex", index);
		request.setAttribute("pageSum", ye);
		return "users";
	}
	@RequestMapping(value="addusers.do",method=RequestMethod.POST)
	public String addusers(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		
		String account = request.getParameter("account");
		String psw = request.getParameter("newpass");
		
		Users u = new Users();
		u.setAccount(account);
		u.setUsername(username);
		u.setEmail(useremail);
		u.setPsw(psw);
		u.setRole(2);
		us.register(u);
		
		return "redirect:user.do";
	}
	@RequestMapping(value="deleteclass.do",method=RequestMethod.GET)
	public String deleteclass(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String classid = request.getParameter("classid");
		ss.deleteStudentByClassId(Integer.parseInt(classid));
		classser.deleteById(Integer.parseInt(classid));
		return "redirect:class.do";
	}
	@RequestMapping(value="delete.do",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String comid = request.getParameter("comid");
		js.deleteJiuye(Integer.parseInt(comid));
		commser.deleteComByid(Integer.parseInt(comid));
		return "redirect:testone.do";
	}
	@RequestMapping(value="deletestudent.do",method=RequestMethod.GET)
	public String deletestudent(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String studid = request.getParameter("studid");
		js.deleteBySid(Integer.parseInt(studid));
		ss.deleteStudent(Integer.parseInt(studid));
		System.out.println(studid);
		return "redirect:student.do";
	}
	@RequestMapping(value="deletestudent.do",method=RequestMethod.POST)
	public String deletestudent1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String banji = request.getParameter("banji");
		Map<String, Object> map = new HashMap<>();
		map.put("classid", Integer.parseInt(banji));
		map.put("pageindex", 0);
		map.put("pagesize", 8);
		List<Student> lis = ss.getByClassid(map);
		request.setAttribute("listStudent", lis);
		List<Class> li =  classser.getAll();
		request.setAttribute("listClass", li);
		return "student";
	}
	@RequestMapping(value="deleteuser.do",method=RequestMethod.GET)
	public String deleteuser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String userid = request.getParameter("userid");
		us.deleteUserById(Integer.parseInt(userid));
		return "redirect:user.do";
	}
    @RequestMapping(value="editclass.do",method=RequestMethod.GET)
	public String editclass(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String classid = request.getParameter("classid");
		Class c = classser.getById(Integer.parseInt(classid));
		request.setAttribute("Class", c);
		return "editclass";
	}
	@RequestMapping(value="editclass.do",method=RequestMethod.POST)
	public String editclass1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String classname = request.getParameter("classname");
		String classaddress = request.getParameter("classaddress");
		String kaishi = request.getParameter("kaishi");
		String jieshi = request.getParameter("jieshi");
		String classid = request.getParameter("classid");
		Class c = new Class();
		c.setClassname(classname);
		c.setClassadreass(classaddress);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ji = null;
			Date shi = null ;
			try {
				ji = sdf.parse(kaishi);
				shi = sdf.parse(jieshi);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			c.setId(Integer.parseInt(classid));
			c.setStarttime(ji);
			c.setEddtime(shi);
			classser.updateById(c);
		
		return "redirect:class.do";
	}
	@RequestMapping(value="edit.do",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String comid = request.getParameter("comid");
		Company c = commser.getComById(Integer.parseInt(comid));
		request.setAttribute("comm", c);
		return "edit";
	}
	@RequestMapping(value="edit.do",method=RequestMethod.POST)
	public String edit1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String comname = request.getParameter("comname");
		String jianjie = request.getParameter("jianjie");
		String xuqiu = request.getParameter("xuqiu");
		String address = request.getParameter("address");
		String cid = request.getParameter("zhuang");
		String comid = request.getParameter("comid");
		String jitime = request.getParameter("ji");
		String shitime = request.getParameter("shi");
		
		Company c = new Company();
		c.setId(Integer.parseInt(comid));
		c.setComname(comname);
		c.setJianjie(jianjie);
		c.setXuqiu(xuqiu);
		c.setAddress(address);
		c.setZhuangtai(cid);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ji = null;
			Date shi = null ;
			try {
				ji = sdf.parse(jitime);
				shi = sdf.parse(shitime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			c.setJitime(ji);
			c.setEndtime(shi);
			commser.updataComByid(c);
		
		return "redirect:testone.do";
	}
	@RequestMapping(value="editstudent.do",method=RequestMethod.GET)
	public String editstudent(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String studentid = request.getParameter("studentid");
		Student s = new Student();
		s = ss.getStudentById(Integer.parseInt(studentid));
		request.setAttribute("student", s);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Class> list =  classser.getAllClass(map);
		request.setAttribute("listClass", list);
		return "editstudent";
	}
	@RequestMapping(value="editstudent.do",method=RequestMethod.POST)
	public String editstudent1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String studentname = request.getParameter("studentname");
		String studentsex = request.getParameter("studentsex");
		String stuid = request.getParameter("stuid");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String bitime = request.getParameter("bitime");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String banji = request.getParameter("banji");
		Student s = new Student();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ji = null;
			try {
				ji = sdf.parse(bitime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			s.setId(Integer.parseInt(stuid));
			s.setName(studentname);
			s.setSex(studentsex);
			s.setSchool(school);
			s.setMajor(major);
			s.setGraduate(ji);
			s.setTel(tel);
			s.setQq(qq);
			s.setClassid(Integer.parseInt(banji));
			ss.updateStudent(s);
		return "redirect:student.do";
	}
	@RequestMapping(value="logout.do",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.invalidate();
		return "redirect:page/index.jsp";
	}
	@RequestMapping(value="searchcombyzhuang.do",method=RequestMethod.GET)
	public String searchcombyzhuang(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Company> list =  commser.getAllByJihua(map);
		request.setAttribute("listCompa", list);
		return "test1";
	}
	@RequestMapping(value="searchcombyzhuang.do",method=RequestMethod.POST)
	public String searchcombyzhuang1(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String cid = request.getParameter("cid");
		System.out.println(cid);
		Map<String, Object> map = new HashMap<>();
		map.put("zhuangtai", cid);
		map.put("pageindex", (1-1)*8);
		map.put("pagesize", 8);
		List<Company> lit = commser.getAllByZhuang(map);
			
		System.out.println(lit);
		
		request.setAttribute("listCompa", lit);
		return "test1";
	}
	@RequestMapping(value="searchcomp.do",method=RequestMethod.GET)
	public String searchcomp(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Company> list =  commser.getAllByShiji(map);
		request.setAttribute("listCompa", list);
		return "test1";
	}
	@RequestMapping(value="searchjiuye.do",method=RequestMethod.POST)
	public String searchjiuye(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String banji = request.getParameter("banji");
		Map<String, Object> map = new HashMap<>();
		map.put("id", Integer.parseInt(banji));
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Jiuye> lit = js.geyAllByClassId(map);
		request.setAttribute("listJiuYe", lit);
		List<Class> li =  classser.getAll();
		request.setAttribute("listClass", li);
		return "test2";
	}
	@RequestMapping(value="updatepaas.do",method=RequestMethod.POST)
	public String updatepaas(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String mpass  = request.getParameter("mpass");
		String newpass  = request.getParameter("newpass");
		Users u = (Users) session.getAttribute("Users");
		Map<String, Object> map = new HashMap<>();
		map.put("xpsw", newpass);
		map.put("jpsw", mpass);
		map.put("id", u.getId());
		us.changePsw(map);
		
		return "redirect:page/pass.jsp";
	}
	@RequestMapping(value="xiang.do",method=RequestMethod.GET)
	public String xiang(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String comid = request.getParameter("comid");
		Company c = commser.getComById(Integer.parseInt(comid));
		request.setAttribute("Comp", c);
		return "xiang";
	}
	@RequestMapping(value="dowload.do",method=RequestMethod.GET)
	public String dowload(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		String fileName = "test1.xls";
		
		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		if(!file.exists()){
			   file.createNewFile();
	 }
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", 1);
		map.put("pagesize", 8);
		List<Jiuye> jiuye = js.getAllJiuye(map);
		 //创建操作Excel的HSSFWorkbook对象
	     HSSFWorkbook excel = new HSSFWorkbook();
	     //创建HSSFSheet对象
	     //Excel中的一个sheet（工作表)对应着java中的一个HSSFSheet对象，
	     //利用HSSFWorkbook对象可以创建一个HSSFSheet对象
	     HSSFSheet sheet = excel.createSheet("jiuye");
	     //创建第一行标题信息的HSSFRow对象
	     HSSFRow firstRow = sheet.createRow(0);
	     //创建标题行中的HSSFCell数组
	     //假设我们一行有五列数据
	     HSSFCell cells[] = new HSSFCell[10];
	     
	    
	     
	     
	     //创建标题数据，并通过HSSFCell对象的setCellValue()方法对每个单元格进行赋值
	     String[] titles = new String[] { "NAME", "sex", "school", "major","graduate","tel","comname","xuqiu","salary",
	       "jiuyetime" };
	     //通过for循环来填充第一行标题的数据
	     for (int i = 0; i < 10; i++) {
	      cells[0] = firstRow.createCell(i);
	      cells[0].setCellValue(titles[i]);
	     }
	    
	     // 向excel中写入数据
	     for (int i = 0; i < jiuye.size(); i++) {
	      HSSFRow row = sheet.createRow(i + 1);
	      Jiuye jiu = jiuye.get(i);
	      HSSFCell cell = row.createCell(0);
	      cell.setCellValue(jiu.getNAME());
	      cell = row.createCell(1);
	      cell.setCellValue(jiu.getSex());
	      cell = row.createCell(2);
	      cell.setCellValue(jiu.getSchool());
	      cell = row.createCell(3);
	      cell.setCellValue(jiu.getMajor());
	      cell = row.createCell(4);
	      cell.setCellValue(jiu.getGraduate());
	      cell = row.createCell(5);
	      cell.setCellValue(jiu.getTel());
	      cell = row.createCell(6);
	      cell.setCellValue(jiu.getComname());
	      cell = row.createCell(7);
	      cell.setCellValue(jiu.getXuqiu());
	      cell = row.createCell(8);
	      cell.setCellValue(jiu.getSalary());
	      cell = row.createCell(9);
	      cell.setCellValue(jiu.getJiuyetime());
	     }
	     //将数据真正的写入excel文件中
	     //做到这里，数据都写好了，最后就是把HSSFWorkbook对象excel写入文件中了。
	           OutputStream out = null;
	           try {
	               out = new FileOutputStream(file);
	               excel.write(out);
	               out.close();
	           } catch (FileNotFoundException e) {
	               e.printStackTrace();
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	           System.out.println("数据已经写入excel"); //温馨提示
		return "redirect:jiuye.do";
	}
}
