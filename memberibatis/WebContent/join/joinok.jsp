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
	<font>${mDto.name}(${mDto.id})님 회원가입을 축하합니다.</font><br>
	가입하신 정보는 다음과 같습니다.<br>
	이메일 : ${mDto.email1}@${mDto.email2}<br>
	전화번호 : ${mDto.tel1}-${mDto.tel2}-${mDto.tel3}<br>
	주소 : ${mDto.zip1}-${mDto.zip2} ${mDto.addr1} ${mDto.addr2}<br>
	로그인후 모든 서비스를 이용할 수 있습니다.<br>
	<a href ="${root}/member?act=mvlogin">로그인</a>
</body>
</html>