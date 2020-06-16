<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加</title>
<%@include file="/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<span class="wel_word">添加用户</span>
			<%@include file="/include/manager_menu.jsp" %>
		</div>

		<div id="main">
			<!-- 表单method默认是get。表单项中的数据会把url地址后的数据全部覆盖 -->
			<form action="${ctp }/user_manager/add">
				<!-- 保存来源的页码 -->
				<input name="pn" value="${pn }" type="hidden"/>
				<table>
					<tr>
						<td>用户名</td>
						<td>密码</td>
						<td>昵称</td>
						<td>性别</td>
						<td>电话</td>
						<td>token</td>
						<td>操作</td>
					</tr>
					<tr>
						<td><input name="account" type="text" /></td>
						<td><input name="password" type="password" /></td>
						<td><input name="name" type="text" /></td>
						<td><input name="gender" type="text" /></td>
						<td><input name="phone" type="text"/></td>
						<td><input name="token" type="text"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				AR项目.Copyright &copy;2020
			</span>
		</div>
</body>
</html>