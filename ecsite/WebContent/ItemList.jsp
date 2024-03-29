<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品一覧</title>
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

#text-link{
display:inline-block;
text-align:right;
}

</style>


</head>
<body>
<body>
     <div id="header">
     <div id="pr">
</div>
</div>
     <div id="main">
     <div id="top">
     <p>ADMIN</p>
</div>
<div>
<s:if test="ItemList==null">
     <h3>商品情報はありません。</h3>
</s:if>
<s:elseif test="message==null">
      <h3>商品情報は以下になります。</h3>
     <table border="1">
  <tr>
     <th>商品名</th>
     <th>値段</th>
     <th>在庫</th>
     <th>登録日</th>
  </tr>
  <s:iterator value="itemList">

  <tr>
     <td><s:property value="itemName" /></td>
     <td><s:property value="itemPrice" /><span>円</span></td>
     <td><s:property value="itemStock" /><span>個</span></td>
     <td><s:property value="insert_date" /></td>
 </tr>
 </s:iterator>
     </table>
     <s:form action="ItemListDeleteConfirmAction">

        <s:submit value="削除" />
        </s:form>
</s:elseif>

<s:if test="message != null">
<h3><s:property value="message"/></h3>
</s:if>
<div id="text-right">
     <p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
     <p>管理者画面トップは<a href='<s:url action="AdminAction" />'>こちら</a></p>
</div>
</div>
</div>
<div id="footer">
     <div id="pr">
     </div>
</div>






</body>
</html>