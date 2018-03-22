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
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
       <c:if test="${sessionScope.Users.role == 3}">
        <li> <a class="button border-main icon-plus-square-o" href="page/adduser.jsp"> 添加内容</a> </li>
        
        </c:if>
		       
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>账户</th>
        <th>姓名</th>
        <th>邮箱</th>
         <c:if test="${sessionScope.Users.role == 3}">
        <th width="310">操作</th>
        </c:if>
      </tr>
       <c:forEach var="ele" items="${requestScope.listUser }" varStatus="s"> 
	        <tr>
	          <td>${ele.account }</td>
	          <td>${ele.username }</td>
	          <td><font color="#1E9FFF">${ele.email }</td>
	           <c:if test="${sessionScope.Users.role == 3}">
	          <td><div class="button-group"><a class="button border-red" href="deleteuser.do?userid=${ele.id }" ><span class="icon-trash-o"></span> 删除</a> </div></td>
	       	</c:if>
	        </tr>
         </c:forEach>
   		
      <tr>
			<td colspan="8">
		        <form method="post" action="user.do" id="form" >
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


</body>
</html>