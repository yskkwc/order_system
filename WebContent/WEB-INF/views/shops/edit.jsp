<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${shop != null}">
                <h2>店舗情報編集ページ</h2>
                <p>（パスワードは変更する場合のみ入力してください）</p>
                <form method="POST" action="<c:url value='/shops/update' />">
                    <c:import url="_form.jsp" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/shops/index' />">登録情報ページに戻る</a></p>
    </c:param>
</c:import>
