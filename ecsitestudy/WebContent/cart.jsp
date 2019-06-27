<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="style.css">


<title>CART</title>
</head>
<body>
<jsp:include page="header.jsp"/>
 <div align="center">
 <s:if test='infomsg!=""'>
 <s:property value="infomsg" escape="false" />
 </s:if>
 <s:else>
 <s:form action="DeleteCartAction">
<table class="cart" align="center">

<tr>

<th> </th>
<th>商品名</th>
<th>商品名かな</th>
<th class="image">画像</th>
<th>値段</th>
<th>発売会社</th>
<th>購入個数</th>
<th>登録日時</th>
<th>合計金額</th>

</tr>

<s:iterator value="cartList">
<tr>

<td>

<input id="check" type="checkbox" name="chkdelete" value='<s:property value="id" />' onclick="checkValue(this)"></td>

<td><s:property value="product_name" /></td>
<td><s:property value="product_name_kana" /></td>
<td><img src='<s:property value="image_file_path" />' class="cartimg"></td>
<td><s:property value="price" /></td>
<td><s:property value="release_company" /></td>
<td><s:property value="product_count" /></td>
<td><s:property value="date" /></td>
<td><s:property value="sumprice" />円</td>

</tr>

</s:iterator>
</table>
計<s:property value="goukei" />円




<s:submit value="削除" id="button" disabled="true"/>

<script type="text/javascript">   <!--テスト用 そのうち別ファイルに分けます 削除ボタンを活性したり非活性にするscript -->
function checkValue(check){
	var button=document.getElementById("button");
	if(check.checked){
		button.removeAttribute("disabled");
	}else{
		button.setAttribute("disabled","true");
	}
}

</script>
</s:form>

<s:form action="SettlementConfirmAction">
<s:submit value="決済" />
</s:form>
</s:else>
</div>
<div id="home">
<br>
<a href='<s:url action="HomeAction"/>'>HOME</a>
</div>

<div id="footer"></div>

</body>
</html>