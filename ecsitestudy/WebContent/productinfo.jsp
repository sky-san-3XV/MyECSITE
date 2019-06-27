<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="style.css">


<title>商品一覧</title>
</head>
<jsp:include page="header.jsp"/>
<div id="main">

    <div id="top">
    <h2>商品詳細</h2>
    </div>


   <div class="LC">
     <img src='<s:property value="#session.image_file_path" />' width="50%">
   </div>

   <div class="RC">
   <s:form action="AddCartAction" >
<table class="product">

<tr>
<td><label>商品名</label></td>
<td><s:property value="#session.detproduct_name" /></td>
</tr>
<tr>
<td><label>商品名かな</label></td>
<td><s:property value="#session.detproduct_name_kana" /></td>
</tr>

<tr>
<td><label>価格</label></td>
<td><s:property value="#session.detprice" />円</td>
</tr>
<tr>
<td><label>個数</label></td>
<td>
     <select name="buynum">
     <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
</select></td>
</tr>
<tr>
<td><label>発売会社</label></td>
<td><s:property value="#session.release_company" /></td>
</tr>
<tr>
<td><label>発売年月日</label></td>
<td><s:property value="#session.release_date" /></td>
</tr>
<tr>
<td><label>説明</label></td>
<td><s:property value="#session.product_desc" /></td>
</tr>
</table>
<br>
<s:submit value="購入する" />
</s:form>
</div>



<div class="kanren">
<s:if test='infomsg !=""'>
<s:property value="infomsg" escape="false" />
</s:if>
<s:else>
<s:iterator value="#session.KANREN">
<ul>
    <li><s:form action="ProductsDetailAction"><input type="image"  name="img"
     src='<s:property value="image_file_name" />' alt="商品詳細" width="40%">
          <input type="hidden" name="product_id" value='<s:property value="product_id" />'></s:form></li>
    <li><s:property value="product_name" /><li>
</ul>
</s:iterator>
</s:else>
</div>
</div>
<div id="home">
<br>
<a href='<s:url action="HomeAction"/>'>HOME</a>
</div>

<div id="footer">
</div>

</body>
</html>