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
<b><%=memberDto.getName() %></b>�� ���� ���<br>
10. ȫ�浿 �ȳ��ϼ���..<br>
9. ŰƮ�� ���� �ȳ��ҳ׿�.<br>
</center>
</body>
</html>
<%}else {
	//response.sendRedirect(root+"/member?act=mvlogin");
	/*�ٷ� �α��� �������� ���� ��. Ŭ���̾�Ʈ�� �� �� ���� �������� ������ ������*/
%>
<script>
	alert("�α����� �̿��Ͻ� �� �ֽ��ϴ�.");
	document.location.href = "<%=root%>/member?act=mvlogin";
	/*Ŭ���̾�Ʈ���� ���� ��ũ��Ʈ�� �ٽ� �������� ��û, Ʈ������ ���� �߻��� �� ����*/
</script>
<%
}
%>