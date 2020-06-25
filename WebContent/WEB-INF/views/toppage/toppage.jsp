<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
  <c:param name="content">
    <c:if test="${hasError}">
      <div id="flush_error">お店の登録名かパスワードが間違っています。</div>
    </c:if>
    <c:if test="${flush != null}">
      <div id="flush_success">
        <c:out value="${flush}"></c:out>
      </div>
    </c:if>
    <h2>注文をはじめる!</h2>
    <br />
    <a href="<c:url value='/orders/shop' />">
      <button type="button">注文する</button>
    </a>
    <br />
    <br />
    <br />
    <br />
    <br />

    <h3>オーナー様ログインページへすすむ</h3>
    <br />
    <a href="<c:url value='/login' />">
      <button type="button">ログイン</button>
    </a>
  </c:param>
</c:import>