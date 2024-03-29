<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Tyoe" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content=""/>
<title>購入確認</title>
<style type="text/css">
/*=== cssとかの辺り style here TAG LAYOUT=== */
body{
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana,Helvetica,sans-serif;
font-size:12px;
color:#333;
background:#fff;
}

table{
text-align:center;
margin:0 auto;
}

/* ===ID LAYOUT=== */

#top{
width:780px;
margin:30px auto;
border:1px solid #333;
}

#header{
width:100%;
height:80px;
background-color:black;
}

#main{
width:100%;
height:500px;
text-align:center;
}

#footer{
width:100%;
height:80px;
background-color:black;
clear:both;
}

</style>
</head>
<body>
     <div id="header">
     <div id="pr">
</div>
</div>
     <div id="main">
     <div id="top">
<p>購入確認</p>
</div>
<div>
<s:form action="BuyItemConfirmAction">
<table>
<tr>
     <td>商品名</td>
     <td><s:property value="session.buyItem_name" /></td>
</tr>
<tr>
     <td>値段</td>
     <td><s:property value="session.buyItem_price" /><span>円</span></td>
</tr>
<tr>
     <td>購入個数</td>
     <td><s:property value="session.stock" /><span>個</span></td>
</tr>
<tr>
     <td>支払い方法</td>
     <td><s:property value="session.pay" /></td>
</tr>
<tr>
     <td><s:submit value="確定" /></td>
</tr>
</table>
</s:form>
</div>
  <div>
     <p>前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
     <p>マイページは<a href='<s:url action="MyPageAction" />'>こちら</a></p>
  </div>
</div>

<div id="footer">
<div id="pr"></div>
</div>
</body>
</html>