<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();

String id = (String) request.getAttribute("searchid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("�˻� ���̵� �Է�!");
		return;
	} else {
		document.idform.action = "<%=root%>/member";
		document.idform.submit();
	}
}

function iduse(id){
	opener.document.getElementById("id").value = id;
	self.close();
}
</script>
</head>
<body>
<center>
<form name="idform" method="get" action="" onsubmit="return false;">
<input type="hidden" name="act" value="idsearch">
<h3>���̵� �ߺ� �˻�</h3>
<table width="350">
<tr>
	<td class="td3">�˻��� ���̵� �Է��ϼ���</td>
</tr>
<tr>
	<td class="td4" style="text-align: center">
	<input type="text" name="id" id="id" onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
	<input type="button" value="�˻�" onclick="javascript:idcheck();">
	</td>
</tr>
<%
if(id == null) {
%>
<tr>
	<td class="td4">
	�˻��� ���̵� ��Ȯ�� �Է��� �� �˻� ��ư�� Ŭ���ϼ���..
	</td>
</tr>
<%
} else {
	int cnt = (Integer) request.getAttribute("count");
	if(cnt == 0) {
%>
<tr>
	<td class="td4">
	<b><%=id %></b>�� ��밡���մϴ�.
	<input type="button" value="���" onclick="javascript:iduse('<%=id %>');">
	</td>
</tr>
	<%
	} else {
	%>
<tr>
	<td class="td4">
	<b><%=id %></b>�� ����Ҽ� �����ϴ�.<br>
	�ٸ� ���̵�� �˻��ϼ���.
	</td>
</tr>
<%
	}
}
%>
</table>
</form>
</center>
</body>
</html>