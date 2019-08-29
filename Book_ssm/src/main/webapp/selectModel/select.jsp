<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${all }">
<option value="-1">全部</option>
</c:if>
<c:forEach items="${optionList }" var="row" varStatus="v">
	<option value="${v.index }"
		<c:if test="${v.index==current }">
				<c:out value="selected='selected'"></c:out>
			</c:if>>${row }</option>
</c:forEach>