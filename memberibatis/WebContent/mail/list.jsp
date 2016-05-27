<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="com.kitri.member.model.*"%>
<%
String root = request.getContextPath();
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");

if (memberDto!= null) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<b><%=memberDto.getName() %></b>님 메일 목록<br>
10. 홍길동 안녕하세요..<br>
9. 키트리 몇일 안남았네요.<br>
</center>
</body>
</html>
<%}else {
	//response.sendRedirect(root+"/member?act=mvlogin");
	/*바로 로그인 페이지로 가게 함. 클라이언트로 갈 때 응답 페이지를 갖고가서 보여줌*/
%>
<script>
	alert("로그인후 이용하실 수 있습니다.");
	document.location.href = "<%=root%>/member?act=mvlogin";
	/*클라이언트에게 보낸 스크립트가 다시 서버에게 요청, 트래픽이 많이 발생될 수 있음*/
</script>
<%
}
%>