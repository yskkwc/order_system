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
                <c:if test="${sessionScope.login_admin != null}">
                    <a href="<c:url value='/admin/new' />">新規管理者を登録</a>&nbsp;
                </c:if>
            </div>
            <c:if test="${sessionScope.login_admin != null}">
                <div id="admin_name">
                <c:out value="${sessionScope.login_admin.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                <a href="<c:url value='/logout' />">ログアウト</a>
                </div>
            </c:if>
          </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                <p>by y.k.</p>
            </div>
        </div>
    </body>
</html>