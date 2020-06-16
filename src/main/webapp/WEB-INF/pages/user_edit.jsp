<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑用户</title>
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
			<span class="wel_word">编辑用户</span>
			<%@include file="/include/manager_menu.jsp" %>
		</div>

		<div id="main">
			<!-- 表单method默认是get。表单项中的数据会把url地址后的数据全部覆盖 -->
			<form action="${ctp }/user_manager/edit">
				<!-- 保存来源的页码 -->

				<table>
					<tr>
						<td>ID</td>
						<td>用户名</td>
						<td>昵称</td>
						<td>性别</td>
						<td>电话</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input readonly="true" name="id" type="text" value="${user_edit.id }"/></td>
						<td><input readonly="true" name="account" type="text" value="${user_edit.account }"/></td>
						<td><input name="name" type="text" value="${user_edit.name }"/></td>
						<td><input name="gender" type="text" value="${user_edit.gender }"/></td>
						<td><input name="phone" type="text" value="${user_edit.phone }"/></td>
						<input name="pn" value="${pn }" type="hidden"/>
						<input name="password" value="${user_edit.password }" type="hidden"/>
						<input name="flag" value="${flag }" type="hidden"/>
						<input name="condition" value="${condition }" type="hidden"/>
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