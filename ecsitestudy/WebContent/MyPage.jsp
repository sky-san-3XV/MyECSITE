<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="style.css">


<title>HOME</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="main">
    <div id="top">
    <h2>マイページ</h2>
    </div>

<table>
<tr>
<td><label>姓</label></td>
<td><span><s:property value="dto.family" /></span></td>
</tr>
<tr>
<td><label>名</label></td>
<td><s:property value="dto.first" /></td>
</tr>
<tr>
<td><label>ふりがな</label></td>
<td><s:property value="dto.familyk" /><span></span><s:property value="dto.firstk" /></td>
</tr>
<tr>
<td><label>性別</label></td>
<td>
<s:if test='dto.sex=="1"'>
男
</s:if>
<s:else>
女
</s:else>
</td>
</tr>
<tr>
<td><label>メールアドレス</label></td>
<td><s:property value="dto.email" /></td>
</tr>
</table>

<s:form action="PurchaseHistoryAction">
<s:submit value="購入履歴" />
</s:form>
</div>
<div id="footer"></div>

</body>
</html>