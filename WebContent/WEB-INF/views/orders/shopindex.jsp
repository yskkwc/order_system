<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
  <c:param name="content">
    <c:if test="${flush != null}">
      <div id="flush_success">
        <c:out value="${flush}"></c:out>
      </div>
    </c:if>
    <h2>注文するお店を選ぶ</h2>
    <table class="usershop_list">
      <thead>
        <tr>
          <th>エリア</th>
          <th>店舗名</th>
          <th>情報</th>
          <th>メニューを選ぶ</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="shop" items="${shops}" varStatus="status">
          <tr class="row${status.count % 2}">
            <c:if test="${shop.area == 1}">
              <td><c:out value="千住エリア" /></td>
            </c:if>
            <c:if test="${shop.area == 2}">
              <td><c:out value="綾瀬エリア" /></td>
            </c:if>
            <c:if test="${shop.area == 3}">
              <td><c:out value="六町エリア" /></td>
            </c:if>
            <c:if test="${shop.area == 4}">
              <td><c:out value="梅島エリア" /></td>
            </c:if>
            <c:if test="${shop.area == 5}">
              <td><c:out value="竹の塚エリア" /></td>
            </c:if>
            <td><c:out value="${shop.name}" /></td>
            <td><c:out value="${shop.info}" /></td>
            <td class="report_action"><a
              href="<c:url value='/orders/menu?id=${shop.id}' />">このお店のメニューを見る</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div id="pagination">
      （全 ${shops_count} 件）<br />
      <c:forEach var="i" begin="1" end="${((shops_count - 1) / 15) + 1}"
        step="1">
        <c:choose>
          <c:when test="${i == page}">
            <c:out value="${i}" />&nbsp;
                    </c:when>
          <c:otherwise>
            <a href="<c:url value='/shops/index?page=${i}' />"><c:out
                value="${i}" /></a>&nbsp;
                    </c:otherwise>
        </c:choose>
      </c:forEach>
    </div>
  </c:param>
</c:import>