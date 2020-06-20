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
        <h1>注文の確認</h1><br />
        <form method="POST" action="<c:url value='/orders/create' />">
        <table id="menu_list">
            <tbody>
                <tr>
                    <th class="menu_name">メニュー名</th>
                    <th class="menu_price">値段</th>
                </tr>
                <c:forEach var="menu" items="${menus}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="menu_name"><c:out value="${menu.name}" /></td>
                        <td class="menu_price">${menu.price}円</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br />
        <input type="submit" VALUE="注文を送信する！">
        </form>
    </c:param>
</c:import>