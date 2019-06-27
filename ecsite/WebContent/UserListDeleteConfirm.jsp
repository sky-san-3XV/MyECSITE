<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認</title>
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
     <p>ユーザー削除確認</p>
</div>
<div>
<h3>本当に削除しても宜しいでしょうか？</h3>



  <s:form action="UserListDeleteCompleteAction">
        <input type="hidden" name="deleteFig" value="1">
        <s:submit value="削除" />
        </s:form>
  <s:form action="UserListAction">
  <s:submit value="戻る" />
  </s:form>

</div>


</div>
<div id="footer">
     <div id="pr">
     </div>
</div>






</body>
</html>