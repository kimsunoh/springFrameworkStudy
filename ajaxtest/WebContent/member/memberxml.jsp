<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kitri.member.MemberDto"%>
<%
List<MemberDto> list = (List<MemberDto>) request.getAttribute("mlist");
System.out.println(list.size());
%>
<memberlist>
<%
for(MemberDto memberDto : list) {
%>
	<member>
		<id><%=memberDto.getId() %></id>
		<name><%=memberDto.getName() %></name>
		<email><%=memberDto.getEmail() %></email>
	</member>
<%	
}
%>
</memberlist>