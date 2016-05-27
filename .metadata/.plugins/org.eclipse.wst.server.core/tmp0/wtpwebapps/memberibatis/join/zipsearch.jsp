<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/style.css" type="text/css">
<script type="text/javascript">
	function dongcheck() {
		if (document.getElementById("dong").value == "") {
			alert("�˻� �� �Է�!");
			return;
		} else {
			document.zipform.action = "${root}/member";
			document.zipform.submit();
		}
	}

	function selectzip(z1, z2, address) {
		opener.document.joinform.zip1.value = z1;
		opener.document.joinform.zip2.value = z2;
		opener.document.joinform.addr1.value = address;
		self.close();
	}
</script>
</head>
<body>
	<center>
		<form name="zipform" method="get" action="">
			<input type="hidden" name="act" value="zipsearch">
			<!-- ȭ�鿡 ǥ�ô� ���� ������ ���� �޾ƿ� �� �ִ� -->
			<h3>������ȣ�˻�</h3>
			<table width="350">
				<tr>
					<td class="td3">�˻��ҵ��� �Է��ϼ���<br>(��: ���ﵿ, ����)
					</td>
				</tr>
				<tr>
					<td class="td4"><input type="text" name="dong" id="dong"
						onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
						<input type="button" value="�˻�" id="btnsearch"
						onclick="javascript:dongcheck();"></td>
				</tr>
				<c:if test="${searchdong == null}">
					<tr>
						<td class="td4">���̸��� ��Ȯ�� �Է��ϼ���.<br>
						</td>
					</tr>
				</c:if>
				<c:if test="${searchdong != null}">
					<c:if test="${ziplist.size() == 0}">
						<tr>
							<td class="td4"><b>${searchdong}</b>���� �˻��� ����� �����ϴ�.<br>
								��Ȯ�� �Է��� �ٽ� �˻��ϼ���.</td>
						</tr>
					</c:if>
					<c:if test="${ziplist.size() != 0}">
						<c:forEach var="zDto" items="${ziplist}">
							<tr>
								<td class="td4"><a
									href="javascript:selectzip('${zDto.zip1}','${zDto.zip2}','${zDto.sido} ${zDto.gugun} ${zDto.dong} ${zDto.bunji}');">
										${zDto.zip1}-${zDto.sido} ${zDto.sido} ${zDto.gugun} ${zDto.dong} ${zDto.bunji}
								</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</c:if>
			</table>
		</form>
	</center>
</body>
</html>