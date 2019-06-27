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
    <h2>ユーザー作成</h2>
    </div>
<div>
     <h3>登録する内容は以下で宜しいでしょうか？</h3>
<table>
<s:form action="UserCreateCompleteAction">
<tr>
     <td><label>姓</label>
     <td><s:property value="family" escape="false" /></td>
</tr>
<tr>
     <td><label>名</label>
     <td><s:property value="first" escape="false" /></td>
</tr>
<tr>
     <td><label>姓かな</label>
     <td><s:property value="familyk" escape="false" /></td>
</tr>
<tr>
     <td><label>名かな</label>
     <td><s:property value="firstk" escape="false" /></td>
</tr>
<tr>
     <td><label>性別</label>
     <td><s:if test="sex==1">男</s:if>
     <s:elseif test="sex==2">女</s:elseif></td>
</tr>
<tr>
     <td><label>メールアドレス</label>
     <td><s:property value="email" escape="false" /></td>
</tr>

<tr>
     <td><label>ログインID:</label></td>
     <td><s:property value="userId" escape="false" /></td>
</tr>
<tr>
     <td><label>LOGINPASS</label></td>
     <td><s:property value="#session.hiddenpass" escape="false" /></td>
</tr>
<s:submit value="決定" />
</s:form>
<s:form action="CreateUserAction">
<s:submit value="戻る" />
</s:form>
</table>
</div>

</div>
<div id="footer"></div>

</body>
</html>