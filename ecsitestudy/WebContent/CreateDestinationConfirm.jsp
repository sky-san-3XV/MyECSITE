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
    <h2>ホーム画面</h2>
    </div>
<div>
     <h3>登録する内容は以下で宜しいでしょうか？</h3>
<table>
<s:form action="CreateDestinationCompleteAction">
<tr>
     <td><label>姓</label>
     <td><s:property value="#session.faname" escape="false" /></td>
</tr>
<tr>
     <td><label>名</label>
     <td><s:property value="#session.finame" escape="false" /></td>
</tr>
<tr>
     <td><label>姓かな</label>
     <td><s:property value="#session.fanamek" escape="false" /></td>
</tr>
<tr>
     <td><label>名かな</label>
     <td><s:property value="#session.finamek" escape="false" /></td>
</tr>

<tr>
     <td><label>住所</label>
     <td><s:property value="#session.address" escape="false" /></td>
</tr>

<tr>
     <td><label>電話番号:</label></td>
     <td><s:property value="#session.telnum" escape="false" /></td>
</tr>
<tr>
     <td><label>メールアドレス</label></td>
     <td><s:property value="#session.email" escape="false" /></td>
</tr>
<s:submit value="決定" />
</s:form>
<s:form action="CreateDestinationAction">
<input type="hidden" name="shinkiFig" value="0" >
<s:submit value="戻る" />
</s:form>
</table>
</div>



</div>
<div id="footer"></div>

</body>
</html>