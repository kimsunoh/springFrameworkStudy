<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="com.kitri.member.model.MemberDto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>MVC Pattern�� �̿��� ȸ������ & �α���</h3>
<a href="${root}/member?act=mvjoin">ȸ������</a>
<c:if test="${userInfo != null}">
	<a href="${root}/member?act=logout">�α׾ƿ�</a>
</c:if>
<c:if test="${userInfo == null}">
	<a href="${root}/member?act=mvlogin">�α���</a>
</c:if>
</body>
</html>