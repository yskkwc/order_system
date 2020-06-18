<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${menu != null}">
                <h2><c:out value="${menu.shop.name}" />様のメニュー</h2>
                <table class="show_menu">
                    <tbody>
                        <tr>
                            <th>メニュー名</th>
                            <td class="show_menu"><c:out value="${menu.name}" /></td>
                        </tr>
                        <tr>
                            <th>値段</th>
                            <td class="show_price"><c:out value="${menu.price}" />円</td>
                        </tr>
                        <tr>
                            <th class="show_menu">メニューの紹介</th>
                            <td class="show_menu">
                            <pre><c:out value="${menu.content}" /></pre>
                            </td>
                        </tr>
                    </tbody>
                </table>
            <p><a href="<c:url value="/menus/edit?id=${menu.id}" />">このメニューを編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/menus/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>