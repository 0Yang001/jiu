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
    <form method="post" class="form-x" action="addjiuye.do">  
      <div class="form-group">
        <div class="label">
          <label>工资：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="gongzi" />
          <div class="tips"></div>
        </div>
      </div>
     
      
     
      <div class="clear"></div>
      
      <div class="form-group">
        <div class="label">
          <label>就业时间：</label>
        </div>
        <div class="field">
		<input type="text" class="input" style="width:280px;" placeholder="请选择日期" readonly="readonly" id="test1" name="jitime">        </div>
      </div>
       
       <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="field">
			<select name="studentname" class="input" style="width:200px; line-height:17px;" >
              <c:forEach var="ele" items="${requestScope.listStudent }" varStatus="s"> 
	              <option value="${ele.id }">${ele.name }</option>
              </c:forEach>
           </select> 
          </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>企业名称：</label>
        </div>
        <div class="field">
			<select name="compname" class="input" style="width:200px; line-height:17px;" >
              <c:forEach var="ele" items="${requestScope.listComp }" varStatus="s"> 
	              <option value="${ele.id }">${ele.comname }</option>
              </c:forEach>
           </select> 
          </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
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
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
elem: '#test2' //指定元素
,type: 'datetime'
});
</script>
</body></html>