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
    <h2>購入履歴</h2>
    </div>
<s:if test='infomsg !=""'>
<s:property value="infomsg" escape="false" />
</s:if>
<s:else>
<s:form action="DeletePurchaseHistoryAction">
<table class="cart" align="center">

<tr>


<th>商品名</th>
<th>商品名かな</th>
<th class="image">画像</th>
<th>会社名</th>
<th>発売年月日</th>
<th>値段</th>
<th>個数</th>
<th>合計金額</th>

</tr>

<s:iterator value="hist">
<tr>
<td><s:property value="product_name" /></td>
<td><s:property value="product_name_kana" /></td>
<td><img src='<s:property value="image_file_path" />' class="cartimg"></td>
<td><s:property value="release_company" /></td>
<td><s:property value="release_date" /></td>
<td><s:property value="price" /></td>
<td><s:property value="product_count" /></td>
<td><s:property value="goukei" />円</td>

</tr>

</s:iterator>
</table>

<s:submit value="削除" />
</s:form>
</s:else>
</div>
<div id="footer"></div>

</body>
</html>