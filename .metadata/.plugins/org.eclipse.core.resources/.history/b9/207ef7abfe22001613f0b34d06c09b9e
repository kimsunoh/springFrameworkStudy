<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kitri.member.MemberDto"%>
<%
List<MemberDto> list = (List<MemberDto>) request.getAttribute("mlist");
System.out.println(list.size());

for(MemberDto memberDto : list) {
%>
	<tr>
		<td bgcolor="#66ffff" border="1"><%=memberDto.getName() %></td>
		<td bgcolor="#66ffff" border="1"><%=memberDto.getId() %></td>
		<td bgcolor="#66ffff" border="1"><%=memberDto.getEmail() %></td>
	</tr>
<%	
}
%>