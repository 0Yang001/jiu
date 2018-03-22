<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/register.css"/>
		<script src="js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="backimg">
		</div>
		<div class="form">
			<form action="register.do" method="post">
				
				
				<div class="from_name">
					<span>
						姓名：
					</span>
					<input type="text" name="username" value="" class="auth" placeholder="请输入您的真实姓名" />
				</div>
				<p class="alery">账号已存在！请重新输入</p>
				
				<div class="from_name">
					<span>
						性别：
					</span>
					<div class="sex" >
						<input type="radio" name="sex" value="男"  />男
						<input type="radio" name="sex" value="女" />女
					</div>
				</div>
				<div class="from_name">
					<span>
						学校：
					</span>
					<input type="text" name="school" value="" class="auth" placeholder="请输入您的学校" />
				</div>
				<div class="from_name">
					<span>
						专业：
					</span>
					<input type="text" name="major" value="" class="auth" placeholder="请输入您的专业" />
				</div>
				<div class="from_name">
					<span>
						毕业时间：
					</span>
					<input type="text" name="biyeshi" value="" class="auth" readonly="readonly" id="test1" placeholder="请选择" />
				</div>
				<div class="from_name">
					<span>
						密码：
					</span>
					<input type="password" name="password" value="" class="auth" placeholder="请输入8位及以上数字或字母" />
				</div>
				<p class="erorr">请输入8位及以上数字或字母</p>
				<div class="from_name">
					<span>
						确认密码：
					</span>
					<input type="password" name="respassword" value="" class="auth" placeholder="确认密码" />
				</div>
				<p class="erorr">两次密码不一致！</p>
				
				<div class="from_name">
					<span>
						手机号：
					</span>
					<input type="text" name="tel" value="" class="auth" max="11" placeholder="请输入11位有效数字" />
				</div>
				<p class="erorr">手机号码格式错误</p>
				<div class="from_name">
					<span>
						QQ号：
					</span>
					<input type="text" name="qq" value="" class="auth" max="11" placeholder="请输入有效数字" />
				</div>
				<div class="from_name">
					<span>
						班级：
					</span>
						<select name="banji" class="auth" >
			              <c:forEach var="ele" items="${requestScope.listClass }" varStatus="s"> 
				              <option value="${ele.id }">${ele.classname }</option>
			              </c:forEach>
			           </select> 	
			           
           			</div>
				
				<div class="form_sub">
					<input type="submit" value="注册" class="zhu"/>
				</div>
				
			</form>
		</div>
		<script src="js/register.js" type="text/javascript" charset="utf-8"></script>
		<script src="page/laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#test1' //指定元素
  ,type: 'datetime'
});
</script>
	</body>
</html>