<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "com.kitri.member.model.MemberDto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<c:set var="mDto" value="${userInfo}"></c:set>
<body>
	<font>${mDto.name}(${mDto.id})�� ȸ�������� �����մϴ�.</font><br>
	�����Ͻ� ������ ������ �����ϴ�.<br>
	�̸��� : ${mDto.email1}@${mDto.email2}<br>
	��ȭ��ȣ : ${mDto.tel1}-${mDto.tel2}-${mDto.tel3}<br>
	�ּ� : ${mDto.zip1}-${mDto.zip2} ${mDto.addr1} ${mDto.addr2}<br>
	�α����� ��� ���񽺸� �̿��� �� �ֽ��ϴ�.<br>
	<a href ="${root}/member?act=mvlogin">�α���</a>
</body>
</html>