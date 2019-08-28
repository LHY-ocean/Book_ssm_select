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
		<input name="name" value="${book.name }">
			<input name="id" type="hidden" value="${book.id }">
			<select name="state">
				<c:forEach items="${states }" var="s" varStatus="v">
					<c:if test="${book.state==v.index }">
						<option value="${v.index }" selected="selected">${s }</option>
					</c:if>
					<c:if test="${book.state!=v.index }">
						<option value="${v.index }">${s }</option>
					</c:if>
				</c:forEach>
			</select>
			<select name="typeid">
				<c:forEach items="${typeList }" var="t">
					<c:if test="${book.typeid==t.id }">
						<option value="${t.id }" selected="selected">${t.name }</option>
					</c:if>
					<c:if test="${book.typeid!=t.id }">
						<option value="${t.id }">${t.name }</option>
					</c:if>
				</c:forEach>
			</select>
		</c:if>
		<c:if test="${param.id==null }">
			<form action="insert.action" method="post">
		<input name="name" value="${book.name }">
			<select name="state">
				<c:forEach items="${states }" var="s" varStatus="v">
					<option value="${v.index }">${s }</option>
				</c:forEach>
			</select>
			<select name="typeid">
				<c:forEach items="${typeList }" var="t">
					<option value="${t.id }">${t.name }</option>
				</c:forEach>
			</select>
		</c:if>
			
		<input type="submit">
	</form>
</body>
</html>