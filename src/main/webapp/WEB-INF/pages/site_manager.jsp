`<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言管理</title>
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
			location.href="${ctp }/site_manager/toSiteManager?pn="+pn;
		});

	});

</script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">留言管理</span>
			<%@include file="/include/manager_menu.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>id</td>
				<td>gid</td>
				<td>horizontal</td>
				<td>vertical</td>
				<td>x</td>
				<td>y</td>
				<td>compass</td>
				<td>content</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${info.list }" var="site">
				<tr>
					<td>${site.id }</td>
					<td>${site.gid }</td>
					<td>${site.horizontal }</td>
					<td>${site.vertical }</td>
					<td>${site.x }</td>
					<td>${site.y }</td>
					<td>${site.compass }</td>
					<td>${site.content }</td>
					<td><a href="${ctp }/site_manager/toEdit?id=${site.id }&pn=${info.pageNum}">修改</a></td>
					<td><a class="delBtn" href="${ctp }/site_manager/delete?id=${site.id }&pn=${info.pageNum}">删除</a></td>
				</tr>	
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="${ctp }/site_manager/toAdd">添加留言</a></td>
			</tr>
		</table>
		<div id="page_nav">
		<a href="${ctp }/site_manager/toSiteManager?pn=1">首页</a>
		<c:if test="${info.hasPreviousPage }">
			<a href="${ctp }/site_manager/toSiteManager?pn=${info.prePage }">上一页</a>
		</c:if>
			<c:forEach items="${info.navigatepageNums}" var="num">
				<c:if test="${num == info.pageNum }">
					【${num }】
				</c:if>
				<c:if test="${num != info.pageNum }">
					<a href="${ctp }/site_manager/toSiteManager?pn=${num }">${num }</a>
				</c:if>
			</c:forEach>

		<c:if test="${info.hasNextPage }">
		<a href="${ctp }/site_manager/toSiteManager?pn=${info.nextPage }">下一页</a>
		</c:if>
		
		<a href="${ctp }/site_manager/toSiteManager?pn=${info.pages }">末页</a>
		共${info.pages }页，${info.total }条记录 到第<input value="${info.pageNum }" name="pn" id="pn_input"/>页
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