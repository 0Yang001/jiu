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
    <form method="post" class="form-x" action="page/home.jsp">  
      <div class="form-group">
        <div class="label">
          <label>公司名称：</label>
        </div>
        <div class="field">
        	${requestScope.Comp.comname }
         <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>公司简介：</label>
        </div>
        <div class="field">
			${requestScope.Comp.jianjie }
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>岗位需求：</label>
        </div>
        <div class="field">
			${requestScope.Comp.xuqiu }

          <div class="tips"></div>
        </div>
      </div>
     
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>公司地址：</label>
        </div>
        <div class="field">
			${requestScope.Comp.address }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>计划招聘时间：</label>
        </div>
        <div class="field">
			${requestScope.Comp.jitime }
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>实际招聘时间：</label>
        </div>
        <div class="field">
			${requestScope.Comp.endtime }
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">返回</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>