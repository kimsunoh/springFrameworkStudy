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
<%=memberDto.getName() %>(<%=memberDto.getId() %>)�� �ȳ��ϼ���.
<a href="<%=root%>/member?act=logout">�α׾ƿ�</a><br>
�̸��� : <%=memberDto.getEmail1() %>@<%=memberDto.getEmail2() %><br>
<a href="<%=root%>/member?act=mail">���Ϻ���</a>
</body>
</html>
<%}else {
	//response.sendRedirect(root+"/member?act=mvlogin");
	/*�ٷ� �α��� �������� ���� ��. Ŭ���̾�Ʈ�� �� �� ���� �������� �������� ������*/
%>
<script>
	alert("�α����� �̿��Ͻ� �� �ֽ��ϴ�.");
	document.location.href = "<%=root%>/member?act=mvlogin";
	/*Ŭ���̾�Ʈ���� ���� ��ũ��Ʈ�� �ٽ� �������� ��û, Ʈ������ ���� �߻��� �� ����*/
</script>
<%
}
%>