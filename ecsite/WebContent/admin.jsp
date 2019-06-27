<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>管理画面</title>

<style type="text/css">
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
    /* ==== ecsite layout  ==== */

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
         .maincont{
         width:100%;
         margin: 0 auto;
         }
         .LC{
         width:30%;
         float:left;
         margin-left:15%;
         margin-right:5%;


         }
         .RC{

         width:30%;
         float:left;
         margin-left:5%;
         margin-right:15%
         }

         .LCCONT,.RCCONT{
         border:1px solid black;
         height:300px;
         font-size:20px;}


   #footer{
          width:100%;
          height:80px;
          background-color:black;
          clear:both;
          }
    #text-center{
          display:inline-block;
          text-align:center;
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
          <p>管理画面<p>
     </div>
<div class="maincont">
<div class="LC">
<h3>商品管理メニュー</h3>
<div class="LCCONT">
<s:form action="ItemCreateAction">
<p><s:submit value="商品を追加する" /></p>
</s:form>
<s:form action="ItemListAction">
<p><s:submit value="商品管理･削除" /></p>
</s:form>
</div>
</div>
<div class="RC">
<h3>ユーザ管理メニュー</h3>
<div class="RCCONT">
<s:form action="UserCreateAdminAction">
<p><s:submit value="ユーザーを追加する" /></p>
</s:form>
<s:form action="UserListAction">
<p><s:submit value="ユーザー管理･削除" /></p>
</s:form>



</div>
</div>
</div>
</div>
<div id="footer">
     <div id="pr">
     </div>
</div>
</body>
</html>