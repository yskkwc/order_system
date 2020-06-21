<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h1>お店のページ</h1><br />
        <h2>受付注文一覧</h2>
        <table id="menu_list">
            <tbody>
                <tr>
                    <th class="menu_name">注文メニュー</th>
                    <th class="menu_price">値段</th>
                    <th class="menu_action">詳細</th>
                </tr>
                <c:forEach var="menu" items="${menus}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="menu_name"><c:out value="${orders.manu.name}" /></td>
                        <td class="menu_price">${orders.address}円</td>
                        <td class="menu_action"><a href="<c:url value='/menus/show?id=${menu.id}' />">詳細を見る・変更する</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:out value="${order.address}"/>
        <c:out value="${shop.name}"/>
        <div id="pagination">
            （全 ${menus_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((reports_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/menus/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:param>
</c:import>