<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
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
<s:if test='errormsg1 !=""'>
     <s:property value="errormsg1" escape="false"  />
</s:if>
<s:if test='errormsg2 !=""'>
     <s:property value="errormsg2" escape="false" />
</s:if>
<s:if test='errormsg3 !=""'>
     <s:property value="errormsg3" escape="false" />
</s:if>
<s:if test='errormsg4 !=""'>
     <s:property value="errormsg4" escape="false" />
</s:if>
<s:if test='errormsg5 !=""'>
     <s:property value="errormsg5" escape="false" />
</s:if>
<s:if test='errormsg6 !=""'>
     <s:property value="errormsg6" escape="false" />
</s:if>
<s:if test='errormsg7 !=""'>
     <s:property value="errormsg7" escape="false" />
</s:if>
<s:if test='errormsg8 !=""'>
     <s:property value="errormsg8" escape="false" />
</s:if>
<s:if test='errormsg9 !=""'>
     <s:property value="errormsg9" escape="false" />
</s:if>

</div>
<table>
<s:form action="UserCreateConfirmAction">
<tr>
     <td><label>姓:</label></td>
     <td><input type="text" name="family" value='<s:property value="#session.family" escape="false" />' ></td>

</tr>
<tr>
     <td><label>名:</label></td>
     <td><input type="text" name="first" value='<s:property value="#session.first" escape="false" />' ></td>
</tr>
<tr>
     <td><label>姓ふりがな:</label></td>
     <td><input type="text" name="familyk" value='<s:property value="#session.familyk" escape="false" />'></td>
</tr>
<tr>
     <td><label>名ふりがな:</label></td>
     <td><input type="text" name=firstk value='<s:property value="#session.firstk" escape="false" />'></td>
</tr>
<tr>
     <td><label>性別:</label></td>
     <td><input type="radio" name="sex" value="1"
     <s:if test='#session.sex==1'><s:property value='checked="checked"' /></s:if>/>男</td>
     <td><input type="radio" name="sex" value="2"
     <s:if test='#session.sex==2'><s:property value='checked="checked"' /></s:if>/>女</td>
</tr>
<tr>
     <td><label>メールアドレス:</label></td>
     <td><input type="text" name="email" value='<s:property value="#session.email" escape="false" />'></td>
</tr>
<tr>
     <td><label>ユーザーID:</label></td>
     <td><input type="text" name="userId" value='<s:property value="#session.userId" escape="false" />'></td>
</tr>
<tr>
     <td><label>パスワード:</label></td>
     <td><input type="text" name="shinkipassword"></td>
</tr>



<s:submit value="登録" />

</s:form>
</table>
</div>
<div id="footer"></div>

</body>
</html>