<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>お店の新規登録</h2>
        <p>以下の空欄を埋めてください<br>
        ※備考欄はかんたんなお店の紹介に使えます。空欄でも構いません。</p>

        <form method="POST" action="<c:url value='/shops/create' />">
            <c:import url="_form.jsp" />
        </form>
        <p><a href="<c:url value='/shops/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>