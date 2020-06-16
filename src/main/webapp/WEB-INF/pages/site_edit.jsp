<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑地点</title>
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
			<span class="wel_word">编辑地点</span>
			<%@include file="/include/manager_menu.jsp" %>
		</div>

		<div id="main">
			<!-- 表单method默认是get。表单项中的数据会把url地址后的数据全部覆盖 -->
			<form action="${ctp }/site_manager/edit">
				<!-- 保存来源的页码 -->
				<input name="pn" value="${pn }" type="hidden"/>
				<input name="flag" value="${flag }" type="hidden"/>
				<input name="condition" value="${condition }" type="hidden"/>
				<table>
					<tr>
						<td>horizontal</td>
						<td>vertical</td>
						<td>x</td>
						<td>y</td>
						<td>compass</td>
						<td>content</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<input name="id" value="${site_edit.id }" type="hidden"/>
						<input name="gid" value="${site_edit.gid }" type="hidden"/>
						<td><input name="horizontal" type="text" value="${site_edit.horizontal }"/></td>
						<td><input name="vertical" type="text" value="${site_edit.vertical }"/></td>
						<td><input name="x" type="text" value="${site_edit.x }"/></td>
						<td><input name="y" type="text" value="${site_edit.y }"/></td>
						<td><input name="compass" type="text" value="${site_edit.compass }"/></td>
						<td><input name="content" type="text" value="${site_edit.content }"/></td>


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