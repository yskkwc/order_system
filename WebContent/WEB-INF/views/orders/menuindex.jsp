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
        <h2>メニュー一覧</h2>
        <table id="menu_list">
            <tbody>
                <tr>
                    <th class="menu_name">メニュー名</th>
                    <th class="menu_price">値段</th>
                    <th class="menu_choice">選択</th>
                </tr>
                <c:forEach var="menu" items="${menus}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="menu_name"><c:out value="${menu.name}" /></td>
                        <td class="menu_price">${menu.price}円</td>
                        <td class="menu_choice"><a href="<c:url value='/orders/new?id=${menu.id}' />">選択する</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br />
        <div id="pagination">
            （全 ${menus_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((reports_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:param>
</c:import>