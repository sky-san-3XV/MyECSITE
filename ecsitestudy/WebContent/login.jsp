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
    <h2>ログイン</h2>
    </div>
    <s:if test='errmsg!=""'>
    <div id="errmsg">
    <s:property value="errmsg" escape="false" />
    </div>
    </s:if>




    <s:form action="LoginAction" theme="simple">
    <table class="login" align="center">
    <tr>
    <td><label>ユーザID</label></td>
    <td><input type="text" name="loginUserId" value='<s:property value="#session.logininputuserid" escape="false" />' size="70"/></td>
    </tr>
    <tr>
    <td><label>パスワード</label></td>
    <td><input type="password" name="loginPassword" size="70"></td>
    </tr>
    </table>
     <input type="hidden" name="keepID" value="0">
    <s:if test='#session.keepid!=null'>

    <input type="checkbox" name="keepID" value="1" checked="checked">IDを保存する
    </s:if>
    <s:else>

    <input type="checkbox" name="keepID" value="1">IDを保存する
    </s:else>
    <br>
    <s:submit value="ログイン" />
    </s:form>







<br>
<div class="btnlogin">
<s:form action="CreateUserAction">
<input type="hidden" name="TopFig" value="1">
<s:submit value="新規登録"/>
</s:form>
</div>
<br>
<div class="btnlogin">
<s:form action="PasswordResetAction">
<input type="hidden" name="PsFig" value="1">
<s:submit value="パスワード再設定" />
</s:form>
</div>





</div>
<div id="footer"></div>

</body>
</html>