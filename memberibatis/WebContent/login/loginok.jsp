<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.kitri.member.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="mDto" value="${userInfo}"></c:set>
<c:if test="mDto != null">
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		${mDto.name}(${mDto.id})�� �ȳ��ϼ���.
		<a href="${root}/member?act=logout">�α׾ƿ�</a>
		<br> �̸��� :
		${mDto.email1}@${mDto.email2}<br>
		<a href="${root}/member?act=mail">���Ϻ���</a>
	</body>
	</html>
</c:if>
<c:if test="mDto == null">
<script>
	alert("�α����� �̿��Ͻ� �� �ֽ��ϴ�.");
	document.location.href = "${root}/member?act=mvlogin";
</script>
</c:if>