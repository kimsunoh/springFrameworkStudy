<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "com.kitri.member.model.MemberDto"%>
<%
	String root = request.getContextPath();
	
	MemberDto memberDto = (MemberDto) request.getAttribute("userInfo");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<font><%=memberDto.getName()%>(<%=memberDto.getId() %>)�� ȸ�������� �����մϴ�.</font><br>
	�����Ͻ� ������ ������ �����ϴ�.<br>
	�̸��� : <%=memberDto.getEmail1() %>@<%=memberDto.getEmail2() %><br>
	��ȭ��ȣ : <%=memberDto.getTel1() %>-<%=memberDto.getTel2() %>-<%=memberDto.getTel3() %> <br>
	�ּ� : <%=memberDto.getZip1() %>-<%=memberDto.getZip2() %> <%=memberDto.getAddr1() %> <%=memberDto.getAddr1() %><br>
	�α����� ��� ���񽺸� �̿��� �� �ֽ��ϴ�.<br>
	<a href ="<%=root %>/member?act=mvlogin">�α���</a>
</body>
</html>