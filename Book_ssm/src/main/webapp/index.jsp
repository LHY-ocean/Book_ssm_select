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
		</select> <input type="submit">
	</form>
	<c:forEach items="${statesList }" var="row">
		${row.name }<br>
	</c:forEach>
</body>
</html>