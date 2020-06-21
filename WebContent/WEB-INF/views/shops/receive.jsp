<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
  <c:param name="content">
    <c:if test="${flush != null}">
      <div id="flush_success">
        <c:out value="${flush}"></c:out>
      </div>
    </c:if>
    <h1>お店のページ</h1>
    <br />
    <h2>受付注文一覧</h2>
    <table id="order_list">
      <tbody>
        <tr>
          <th class="order_date">受注時刻</th>
          <th class="order_name">注文メニュー</th>
          <th class="order_number">注文個数</th>
          <th class="order_action">詳細をみる</th>
        </tr>
        <c:forEach var="order" items="${orders}" varStatus="status">
          <tr class="row${status.count % 2}">
            <td class="order_date"><fmt:formatDate
                value="${order.order_date}" pattern="yyyy/MM/dd kk:mm" /></td>
            <td class="order_name"><c:out value="${order.menu.name}" /></td>
            <td class="order_number">${order.number}</td>
            <td class="order_action"><a
              href="<c:url value='/shops/show?id=${order.id}' />">詳細を見る</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div id="pagination">
      （全 ${orders_count} 件）<br />
      <c:forEach var="i" begin="1" end="${((orders_count - 1) / 15) + 1}"
        step="1">
        <c:choose>
          <c:when test="${i == page}">
            <c:out value="${i}" />&nbsp;
                    </c:when>
          <c:otherwise>
            <a href="<c:url value='/orders/index?page=${i}' />"><c:out
                value="${i}" /></a>&nbsp;
                    </c:otherwise>
        </c:choose>
      </c:forEach>
    </div>
  </c:param>
</c:import>