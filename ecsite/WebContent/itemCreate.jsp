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
<title>[admin]Add Item</title>

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
          <p>商品を追加する<p>
     </div>
<div>
     <h3>商品を追加します。</h3>
     <s:if test='errorMessage !=""'>
     <s:property value="errorMessage" escape="false" />
</s:if>
     <table>
     <s:form action="ItemCreateConfirmAction">
     <tr>
     <td><label>商品名:</label></td>
     <td><s:textfield name="itemName" /></td>
     <td><label>価格(円)(半角数字で入力):</label>
     <td><s:textfield name="itemPrice" /></td>
     <td><label>在庫数(個)(半角数字で入力):</label></td>
     <td><s:textfield name="itemStock" /></td>

     <s:submit value="登録する" />
     </tr>
     </s:form>
     </table>
</div>

</div>
<div id="footer">
     <div id="pr">
     </div>
</div>
</body>
</html>