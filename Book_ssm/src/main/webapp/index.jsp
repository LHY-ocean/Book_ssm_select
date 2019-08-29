<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>

</head>
<body>

	<script type="text/javascript">
var s="${opt}";
	function chan(o){
		if(o.value==0){
			a1.style.display="inline";
			a2.style.display="none";
		}else{
			a2.style.display="inline";
			a1.style.display="none";
		}
	}
	$(function(){
		$("[name=opt]").val(s.length>0?s:0);
		if(s.length==0||s==0){
			a1.style.display="inline";
			a2.style.display="none";
		}else{
			a2.style.display="inline";
			a1.style.display="none";
		}
	})
	
</script>
	<form action="index.action" method="post" enctype="application/json">
		<select name="opt" onchange="chan(this);">
			<option value="0">名称查询</option>
			<option value="1">状态查询</option>
		</select> 
		<input name="txt" id="a1" value="${txt}"> 
		<select name="state" id="a2" style="display: none;">
			<c:set var="all" value="true" scope="request"></c:set>
			<c:set var="optionList" value="${states}" scope="request"></c:set>
			<c:set var="current" value="${state}" scope="request"></c:set>
			<c:import url="selectModel/select.jsp"></c:import>
		</select> 
		<input type="submit">
	</form>
	<c:forEach items="${statesList }" var="row">
		${row.name }<br>
	</c:forEach>
</body>
</html>