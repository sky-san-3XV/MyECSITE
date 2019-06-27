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
    <h2>新規宛先作成</h2>
    </div>
<div>
<s:if test='errmsg1 !=""'>
     <s:property value="errmsg1" escape="false" />
</s:if>
<s:if test='errmsg2 !=""'>
     <s:property value="errmsg2" escape="false" />
</s:if>
<s:if test='errmsg3 !=""'>
     <s:property value="errmsg3" escape="false" />
</s:if>
<s:if test='errmsg4 !=""'>
     <s:property value="errmsg4" escape="false" />
</s:if>
<s:if test='errmsg5 !=""'>
     <s:property value="errmsg5" escape="false" />
</s:if>
<s:if test='errmsg6 !=""'>
     <s:property value="errmsg6" escape="false" />
</s:if>
<s:if test='errmsg7 !=""'>
     <s:property value="errmsg7" escape="false" />
</s:if>
</div>
<table>
<s:form action="CreateDestinationConfirmAction">
<tr>
     <td><label>姓:</label></td>
     <td><input type="text" name="faname" value='<s:property value="#session.faname" escape="false" />' /></td>

</tr>
<tr>
     <td><label>名:</label></td>
     <td><input type="text" name="finame" value='<s:property value="#session.finame" escape="false" />' /></td>
</tr>
<tr>
     <td><label>姓ふりがな:</label></td>
     <td><input type="text" name="fanamek" value='<s:property value="#session.fanamek" escape="false" />' /></td>
</tr>
<tr>
     <td><label>名ふりがな:</label></td>
     <td><input type="text" name="finamek" value='<s:property value="#session.finamek" escape="false" />'/></td>
</tr>

<tr>
     <td><label>住所:</label></td>
     <td><input type="text" name="address" value='<s:property value="#session.address" escape="false" />' /></td>
</tr>
<tr>
     <td><label>電話番号:</label></td>
     <td><input type="text" name="telnum" value='<s:property value="#session.telnum" escape="false" />' /></td>
</tr>
<tr>
     <td><label>メールアドレス:</label></td>
     <td><input type="text" name="email" value='<s:property value="#session.email" escape="false" />' /></td>
</tr>



<s:submit value="登録" />

</s:form>
</table>


</div>
<div id="footer"></div>

</body>
</html>