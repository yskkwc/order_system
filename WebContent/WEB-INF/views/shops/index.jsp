<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
  <c:param name="content">
    <c:if test="${flush != null}">
      <div id="flush_success">
        <c:out value="${flush}"></c:out>
      </div>
    </c:if>
    <h2>サイト管理者ログイン</h2>
    <table class="shop_list">
              <thead>
                <tr>
                    <th>店舗名</th>
                    <th>住所</th>
                    <th>メールアドレス</th>
                    <th>電話番号</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="shop" items="${shops}" varStatus="status">
                <tr class="row${status.count % 2}">
                  <td><c:out value="${shop.name}" /></td>
                  <td><c:out value="${shop.address}" /></td>
                  <td><c:out value="${shop.email}" /></td>
                  <td><c:out value="${shop.denwa}" /></td>
                </tr>
                </c:forEach>
              </tbody>
        </table>
        <div id="pagination">
            （全 ${shops_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((shops_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/shops/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/shops/new' />">テスト用アカウントの作成</a></p>
  </c:param>
</c:import>