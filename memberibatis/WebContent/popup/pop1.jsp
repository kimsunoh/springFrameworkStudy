<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();
	String flag = request.getParameter("falg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function adcheck(){
	if(document.getElementsByName("adcb")[0].checked){
		document.location.href = "<%=root%>/member?act=popcheck";
	}else{
		self.close();
	}
}

function closepop(){
	<%if("true".equals(flag)){%>
		self.close();
	<%}%>
}
</script>
</head>
<body onclick="javascript:closepop();">
	<center >
		<table width="300" height="400">
			<tr>
				<td width="300" height="350">
					<img src="<%=root%>/img/a.jpg">
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="checkbox" name="adcb" value="adCheck">
					<a href="javascript:adcheck();">오늘은 그만볼래요</a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>