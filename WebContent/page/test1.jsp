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
      	<c:if test="${sessionScope.Users.role == 2 || sessionScope.Users.role == 3}">
       		 <li> <a class="button border-main icon-plus-square-o" href="page/add.jsp"> 添加内容</a> </li>
        </c:if>
      	
          <li>
        <form method="post" action="searchcombyzhuang.do" >
          
          <li>
           <select name="cid" class="input" style="width:200px; line-height:17px;" style="display:inline;" >
              <option value="招聘中">招聘中</option>
              <option value="招聘结束">招聘结束</option>
            </select>
        </li>
           	<input type ="submit" class="button border-main icon-search" />
          
          </form>
          </li>
      
        <li>
	      <form method="post" action="testone.do" id="form" >
	          <input type="text" placeholder="请输入搜索公司名称" name="commmname" class="input" style="width:250px; line-height:17px;display:inline-block" />
	          <input type ="submit" class="button border-main icon-search" />
	 	  
     	 </li>
      </ul>
    </div>
    
    
    <table class="table table-hover text-center">
    	
      <tr>
        <th width="10%">公司名称</th>
        <th>计划招聘时间</th>
        <th>实际招聘时间</th>
        <th>公司地址</th>
        <th>招聘状态</th>
        <th width="310">操作</th>
      </tr>
    
      <c:forEach var="ele" items="${requestScope.listCompa }" varStatus="s"> 
        <tr>
          <td>${ele.comname }</td>
          <td>${ele.jitime }</td>
          <td>${ele.endtime }</td>
          <td><font color="#00CC99">${ele.address }</font></td>
          <td>${ele.zhuangtai }</td>
          <td>
          	<div class="button-group"> 
	          <a class="button border-main" href="xiang.do?comid=${ele.id }"><span class="icon-edit"></span> 查看</a>
	          <c:if test="${sessionScope.Users.role == 2 || sessionScope.Users.role == 3}">
		          <a class="button border-main" href="edit.do?comid=${ele.id }"><span class="icon-edit"></span> 修改</a>
		          <a class="button border-red" href="delete.do?comid=${ele.id }" ><span class="icon-trash-o"></span> 删除</a>
	           </c:if>
			</div>
		</td>
        </tr>
        </c:forEach>
   		
     	  <tr>
	       	 <td colspan="7" style="text-align:left;padding-left:20px;">  操作： <a href="searchcombyzhuang.do" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit"> 排序（计划）</a>
	         <a href="searchcomp.do" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit" > 排序（实际）</a>
  		</td>
  		</tr>
  		
	      <tr>
	        <td colspan="8">
	        
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