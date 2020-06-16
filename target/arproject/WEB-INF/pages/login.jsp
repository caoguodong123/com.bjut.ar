<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<%@include file="/include/base.jsp" %>
</head>
<% session.setAttribute("ctp", request.getContextPath()); %>
<body>
		<div id="login_header">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>AR管理后台</h1>

							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg"><!-- 请输入用户名和密码 -->
									${empty msg?"请输入用户名和密码":msg}
								</span>
							</div>
							<div class="form">
								<form action="${ctp }/admin/login" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="account" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				AR项目.Copyright &copy;2020
			</span>
		</div>
</body>
</html>