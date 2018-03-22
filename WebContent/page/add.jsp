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
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="../add.do">  
      <div class="form-group">
        <div class="label">
          <label>公司名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="compname" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>公司简介：</label>
        </div>
        <div class="field">
          <textarea class="input" name="jianjie" style=" height:100px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>岗位需求：</label>
        </div>
        <div class="field">
          <textarea name="xuqiu" class="input" style="height:80px; border:1px solid #ddd;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
     
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>公司地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="address"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>计划招聘时间：</label>
        </div>
        <div class="field">
		<input type="text" class="input" style="width:280px;" placeholder="请选择日期" readonly="readonly" id="test1" name="jitime">        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>实际招聘时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input" style="width:280px;" placeholder="请选择日期" readonly="readonly" name="shitime" id="test2" />
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>招聘状态：</label>
        </div>
        <div class="field">
			<select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
              <option value="招聘中">招聘中</option>
              <option value="招聘结束">招聘结束</option>
            </select>        </div>
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
<script src="laydate/laydate.js"></script> <!-- 改成你的路径 -->
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