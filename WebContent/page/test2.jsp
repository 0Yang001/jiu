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
    <script src="js/fen.js"></script> 
</head>
<body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <a href="dowload.do" class="button border-green" id="checkall"><span class="icon-check"></span> 下载</a>
		</li>	
		<c:if test="${sessionScope.Users.role == 2 || sessionScope.Users.role == 3}">
       		 <li> <a class="button border-main icon-plus-square-o" href="addjiuye.do"> 添加内容</a> </li>
        </c:if>
        <form method="post" action="searchjiuye.do">
          
          <li>
          <select name="banji" class="input" style="width:200px; line-height:17px;" >
              <c:forEach var="ele" items="${requestScope.listClass }" varStatus="s"> 
	              <option value="${ele.id }">${ele.classname }</option>
              </c:forEach>
           </select> 
       	</li>
           	<input type ="submit" class="button border-main icon-search" />
         </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">姓名</th>
        <th>性别</th>       
        <th>毕业院校</th>
        <th>专业</th>
        <th>毕业时间</th>
        <th>电话</th>
        <th>就业单位</th>
        <th>职位</th>  
        <th>工资</th>
        <th>就业时间</th>      
      </tr>   
      <c:forEach var="ele" items="${requestScope.listJiuYe }" varStatus="s">    
	        <tr>
	          <td>${ele.NAME }</td>
	          <td>${ele.sex }</td>
	          <td>${ele.school }</td>
	          <td>${ele.major }</td>  
	           <td>${ele.graduate }</td>         
	          <td>${ele.tel }</td>
	          <td>${ele.comname }</td>
	          <td>${ele.xuqiu }</td>
	          <td>${ele.salary }</td>
	          <td>${ele.jiuyetime }</td>
	        </tr>
        </c:forEach>
       
      <tr>
			<td colspan="8">
		        <form method="post" action="jiuye.do" id="form" >
		        	<input type="hidden" value="${requestScope.pageindex }" id="index" name="index" />
					<input type="hidden" value="${requestScope.pageSum }" id="sum" name="sum" />
		        	<div class="pagelist"> 
			        	<a href="" id="one" class="ye">首页</a>
			        	<a href="" id="two" class="ye">上一页</a>
			        	<a href="" id="free" class="ye">下一页</a>
			        	<a href="" id="tour" class="ye">尾页</a>
		        	 </div>
		         </form>
		        </td>   
		    </tr>
    </table>
  </div>
<script type="text/javascript">
	$(function(){
		$('#checkall').click(function(){
			alert("已下载！位置自己慢慢找，反正我已经找到了！");
		});
	});
</script>

</body></html>