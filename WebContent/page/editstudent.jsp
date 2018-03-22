<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="editstudent.do">
    <input type="hidden" name="stuid" value="${requestScope.student.id }" />  
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${requestScope.student.name }" name="studentname" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="radio" value="男" name="studentsex" checked="checked" />男
          <input type="radio"  value="女" name="studentsex"  />女
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学校：</label>
        </div>
        <div class="field">
          <textarea class="input" name="school" style=" height:100px;">${requestScope.student.school }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>专业：</label>
        </div>
        <div class="field">
          <textarea name="major" class="input" style="height:80px; border:1px solid #ddd;">${requestScope.student.major }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>毕业时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input" style="width:280px;" readonly="readonly" id="test1"  name="bitime" value="${requestScope.student.graduate }" />
        </div>
      </div>
     
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input"  name="tel" value="${requestScope.student.tel }" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>QQ：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="qq" value="${requestScope.student.qq }" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>班级：</label>
        </div>
        <div class="field">
          <select name="banji" class="input" style="width:200px; line-height:17px;" >
              <c:forEach var="ele" items="${requestScope.listClass }" varStatus="s"> 
	              <option value="${ele.id }">${ele.classname }</option>
              </c:forEach>
           </select> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="page/laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#test1' //指定元素
  ,type: 'datetime'
});
</script>
</body></html>