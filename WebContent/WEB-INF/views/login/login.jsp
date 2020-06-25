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
    <h2>ご注文のお客様：注文ページへすすむ</h2>
    <br />
    <a href="<c:url value='/orders/shop' />">
      <button type="button">注文する</button>
    </a>
    <br />
    <br />
    <br />
    <br />
    <br />

    <h2>お店オーナー様：ログインページへすすむ</h2>
    <form method="POST" action="<c:url value='/login' />">
      <label for="name">お店の登録名</label><br /> <input type="text"
        name="name" value="${name}" /> <br />
      <br /> <label for="password">パスワード</label><br /> <input
        type="password" name="password" /> <br />
      <br /> <input type="hidden" name="_token" value="${_token}" />
      <button type="submit">ログイン</button>
    </form>
    <br />
    <p>＊ポートフォリオ用プリセットアカウントログイン＊</p>
    <form method="POST" action="<c:url value='/login' />">
    <input type="hidden" name="name" value="テストアカウント" />
    <input type="hidden" name="password" value="admin" />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">テストアカウント</button>
    </form>
    <form method="POST" action="<c:url value='/login' />">
    <input type="hidden" name="name" value="ラーメン店" />
    <input type="hidden" name="password" value="ramen" />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">ラーメン店</button>
    </form>
    <form method="POST" action="<c:url value='/login' />">
    <input type="hidden" name="name" value="パスタ店" />
    <input type="hidden" name="password" value="pasta" />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">パスタ店</button>
    </form>
    <form method="POST" action="<c:url value='/login' />">
    <input type="hidden" name="name" value="ハンバーグ店" />
    <input type="hidden" name="password" value="hamberg" />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">ハンバーグ店</button>
    </form>
    <form method="POST" action="<c:url value='/login' />">
    <input type="hidden" name="name" value="居酒屋" />
    <input type="hidden" name="password" value="izakaya" />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">居酒屋</button>
    </form><br/><br/>

    <h3>お店を新規登録する！</h3>
    <br />
    <a href="<c:url value='/shops/new' />">
      <button type="button">新規登録</button>
    </a>
  </c:param>
</c:import>