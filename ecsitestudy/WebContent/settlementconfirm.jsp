<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="style.css">


<title>選択</title>
<script type="text/javascript">

function Comp(){
	document.getElementById('settle').action="SettlementCompleteAction";

}
function Del(){
	document.getElementById('settle').action="DeleteDestinationAction";
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="main">
    <div id="top">
    <h2>ホーム画面</h2>
    </div>
<s:if test='msg !=""'>
<s:property value="msg" escape="false" />
</s:if>
<s:else>
<div class="msg1">決済情報を選択してください。</div>

<s:form id="settle">
<table class="dest" align="center">

<tr>
  <th>#</th>
  <th>姓</th>
  <th>名</th>
  <th>姓ふりがな</th>
  <th>名ふりがな</th>
  <th>住所</th>
  <th>TEL</th>
  <th>メールアドレス</th>
</tr>

<s:iterator value="di" status="di">
<tr>

<s:if test="#di.index==0">
<td><input type="radio" name="id" value='<s:property value="id" />' checked="checked"></td>
</s:if>
<s:else>
<td><input type="radio" name="id" value='<s:property value="id" />'></td>
</s:else>

<td><s:property value="faname" /></td>
<td><s:property value="finame" /></td>
<td><s:property value="fanamek" /></td>
<td><s:property value="finamek" /></td>
<td><s:property value="address" /></td>
<td><s:property value="telnum" /></td>
<td><s:property value="email" /></td>



</tr>

</s:iterator>
</table>
<input type="submit" value="確定" onClick="Comp()" >
<input type="submit" value="削除" onClick="Del()" >

</s:form>



</s:else>
<s:form action="CreateDestinationAction">
<input type="hidden" name="shinkiFig" value="1">
<s:submit value="新規作成" />
</s:form>
</div>
<div id="footer"></div>

</body>
</html>