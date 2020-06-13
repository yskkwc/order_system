<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>かんたん注文</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
          <div id="header">
            <div id="header_menu">
                <h1><a href="<c:url value='/' />">かんたん注文</a></h1>&nbsp;&nbsp;&nbsp;
                <c:if test="${sessionScope.login_shop != null}">
                    <a href="<c:url value='/shops/index' />">お店情報を編集</a>&nbsp;
                    <a href="<c:url value='/menus/new' />">メニューを追加</a>&nbsp;
                </c:if>
            </div>
            <c:if test="${sessionScope.login_shop != null}">
                <div id="employee_name">
                <c:out value="${sessionScope.login_shop.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                <a href="<c:url value='/logout' />">ログアウト</a>
                </div>
            </c:if>
          </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by y.k.
            </div>
        </div>
    </body>
</html>