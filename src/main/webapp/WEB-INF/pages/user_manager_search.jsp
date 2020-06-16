`<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<%@include file="/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			var tdEle = $(this).parents("tr").find("td:first");
			if(!confirm("确认删除【"+tdEle.text()+"】吗？")){
				return false;
			}
			
		});
		
		
		//点击确定跳转到对应页面
		$("#gotoPageBtn").click(function(){
			var pn = $("#pn_input").val();
			location.href="${ctp }/user_manager/getUserByName?pn="+pn+"&condition=${condition }";
		});
		
	});

</script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">用户管理</span>
			<%@include file="/include/manager_menu.jsp" %>
	</div>
	
	<div id="main">
		<div class="book_cond">
			<form action="${ctp }/user_manager/getUserByName">
				昵称：<input type="text" name="condition">
				<button>查询</button>
			</form>
		</div>
		<table>
			<tr>
				<td>id</td>
				<td>用户名</td>
				<td>密码</td>
				<td>昵称</td>
				<td>性别</td>
				<td>电话</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${info.list }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.account }</td>
					<td>${user.password }</td>
					<td>${user.name }</td>
					<td>${user.gender }</td>
					<td>${user.phone }</td>
					<td><a href="${ctp }/user_manager/toEdit?id=${user.id }&pn=${info.pageNum}&flag=2&condition=${condition }">修改</a></td>
					<td><a class="delBtn" href="${ctp }/user_manager/delete?id=${user.id }&pn=${info.pageNum}&flag=2&condition=${condition }">删除</a></td>
				</tr>	
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="${ctp }/user_manager/toAdd">添加用户</a></td>
			</tr>	
		</table>
		<div id="page_nav">
		<a href="${ctp }/user_manager/getUserByName?pn=1&condition=${condition }">首页</a>
		<c:if test="${info.hasPreviousPage }">
			<a href="${ctp }/user_manager/getUserByName?pn=${info.prePage }&condition=${condition }">上一页</a>
		</c:if>
			<c:forEach items="${info.navigatepageNums}" var="num">
				<c:if test="${num == info.pageNum }">
					【${num }】
				</c:if>
				<c:if test="${num != info.pageNum }">
					<a href="${ctp }/user_manager/getUserByName?pn=${num }&condition=${condition }">${num }</a>
				</c:if>
			</c:forEach>

		<c:if test="${info.hasNextPage }">
		<a href="${ctp }/user_manager/getUserByName?pn=${info.nextPage }&condition=${condition }">下一页</a>
		</c:if>
		
		<a href="${ctp }/user_manager/getUserByName?pn=${info.pages }&condition=${condition }">末页</a>
		共${info.pages }页，${info.size }条记录 到第<input value="${info.pageNum }" name="pn" id="pn_input"/>页
		<input type="button" value="确定" id="gotoPageBtn">
		</div>
	</div>
	
	<div id="bottom">
		<span>
			AR项目.Copyright &copy;2020
		</span>
	</div>
</body>
</html>