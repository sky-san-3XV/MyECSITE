
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<script type="text/javascript">
function Search(){
	document.getElementById("headid").action="SearchAction";
}

function Logout(){
	document.getElementById('headid').action="LogoutAction";

}
function Login(){
	document.getElementById('headid').action="HomeLoginAction";
}

function Cart(){
	document.getElementById("headid").action="CartAction";
}
function Product(){
	document.getElementById("headid").action="ProductsAction";
}

function Mypage(){
	document.getElementById("headid").action="MyPageAction";
}
</script>


<header>
<div id="title">
GENUINE
</div>
<div class="headmenu">
<ul>
<s:form id="headid" theme="simple">
<s:if test="#session.cat.size()>0">

     <li><s:select name="category" list="#session.cat" listKey="id" listValue="category" id="id" headerValue="すべてのカテゴリ" headerKey="0" class="selectcat" /></li>

</s:if>

     <li><input type="text" name="searchwords" value='<s:property value="#session.searchwords" />'  placeholder="検索ワード"></li>
     <li><input type="submit" value="検索" onClick="Search()"></li>
<s:if test="#session.logined==1" >
     <li><input type="submit" value="ログアウト" onClick="Logout()"></li>
</s:if>
<s:else>
     <li><input type="submit" value="ログイン" onClick="Login()"></li>
</s:else>
     <li><input type="submit" value="カート" onClick="Cart()"></li>
     <li><input type="submit" value="商品一覧" onClick="Product()"></li>
<s:if test="#session.logined==1">
     <li><input type="submit" value="マイページ" onClick="Mypage()" ></li>
</s:if>
</s:form>
</ul>
</div>
</header>