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
    <h2>パスワード再設定</h2>
    </div>

    <s:if test='errmsg!=""'>
     <s:property value="errmsg" escape="false" />
     </s:if>
 <table>
    <s:form action="PasswordResetConfirmAction">
    <tr>
    <td>ユーザID</td>
    <td><input type="text" name="loginUserId" value='<s:property value="#session.loginUserId" />'/></td>
    </tr>
    <tr>
    <th>パスワード</th>
    <th><input type="password" name="loginPassword" value=""></th>
    </tr>
    <tr>
    <td>パスワード（新）</td>
    <td><input type="text" name="loginPasswordnew" value=""></td>
    </tr>
    <tr>
    <td>パスワード（再)</td>
    <td><input type="text" name="loginPasswordnew2" value=""></td>
    </tr>
    <s:submit value="確認" />
    </s:form>
    </table>

</div>
<div id="footer"></div>

</body>
</html>