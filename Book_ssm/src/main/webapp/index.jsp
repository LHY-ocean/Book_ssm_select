<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/tag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="index.action">
		<my:selectbyarray items="${states }" name="txt" all="true" current="${state }" ></my:selectbyarray>
		<my:selectbylist items="${bookList }" name="text" all="true" current="${bid }"></my:selectbylist>
		<my:selectbylist items="${typeList }" name="type" all="true" current="${type }"></my:selectbylist>
		</select> <input type="submit">
	</form>
	<table>
		<tr>
			<th>姓名</th>
			<th>类型</th>
			<th>外键</th>
		</tr>
		
			<c:forEach items="${statesList }" var="row">
			<tr>
				<td>${row.name }</td>
				<td>${row.statename }</td>
				<td>${row.typename }</td>
				</tr>
			</c:forEach>
		
	</table>
</body>
</html>