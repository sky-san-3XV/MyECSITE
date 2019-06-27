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
<body>
<jsp:include page="header.jsp"/>
<div id="main">
    <div id="top">
    <h2>商品一覧</h2>
    </div>
<s:if test='message != ""'>
<s:property value="message" escape="false" />
</s:if>
<s:else>

<div id="list">
<s:iterator value="ProList">


  <ul>
     <li><s:form action="ProductsDetailAction"><input type="image"  name="img"
     src='<s:property value="image_file_path" />'
          alt="商品詳細" width="50%" class="prodimage"><input type="hidden" name="product_id" value='<s:property value="product_id" />'></s:form></li>
     <li><s:property value="product_name" /><span></span></li>
     <li><s:property value="product_namek" /><span></span></li>
     <li><s:property value="price" />円</li>
 </ul>

 </s:iterator>



</div>

</s:else>
</div>

<div id="home">
<a href='<s:url action="HomeAction"/>'>HOME</a>
</div>

<div id="footer"></div>

</body>
</html>