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
    <h2>確認</h2>
    </div>

<h3>以下のとおりで登録します。よろしいですか？</h3>

<s:form action="PasswordResetCompleteAction">
<tr>
     <td><label>ユーザID</label>
     <td><s:property value="loginUserId" escape="false" /></td>
</tr>
<tr>
     <td><label>パスワード</label>
     <td><s:property value="#session.hiddenpass" escape="false" /></td>
</tr>
<s:submit value="変更する" />
</s:form>
<s:form action="PasswordResetAction">
<s:submit value="戻る" />

</s:form>

</div>
<div id="footer"></div>

</body>
</html>