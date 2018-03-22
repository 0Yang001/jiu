<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    <form method="post" class="form-x" action="editclass.do">  
    <input type="hidden" name="classid" value="${requestScope.Class.id }"/>
      <div class="form-group">
        <div class="label">
          <label>班级名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="classname" value="${requestScope.Class.classname }" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>班级地址：</label>
        </div>
        <div class="field">
          <textarea class="input" name="classaddress" style=" height:100px;">${requestScope.Class.classadreass }</textarea>
          <div class="tips"></div>
        </div>
      </div>
     
      <div class="form-group">
        <div class="label">
          <label>开班时间：</label>
        </div>
        <div class="field">
		<input type="text" class="input" style="width:280px;" readonly="readonly"  id="tt1" name="kaishi" value="${requestScope.Class.starttime }" >        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input" style="width:280px;" readonly="readonly" name="jieshi" id="tt2" value="${requestScope.Class.eddtime }" />
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
  elem: '#tt1' //指定元素
  ,type: 'datetime'
});
laydate.render({
	  elem: '#tt2' //指定元素
	  ,type: 'datetime'
	});
</script>
</body></html>