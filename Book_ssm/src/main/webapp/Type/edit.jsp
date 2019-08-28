<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${param.id!=null }">
			<form action="update.action" method="post">
				<input name="name" value="${type.name }">
				<input name="id" type="hidden" value="${type.id }">
		</c:if>
		<c:if test="${param.id==null }">
			<form action="insert.action" method="post">
				<input name="name" value="${type.name }">
		</c:if>	
			<input type="submit" value="提交">
	</form>
</body>
</html>