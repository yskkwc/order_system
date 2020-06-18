<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
  <c:param name="content">
    <c:if test="${flush != null}">
      <div id="flush_success">
        <c:out value="${flush}"></c:out>
      </div>
    </c:if>
    <h2>お店の登録情報</h2>
    <table class="shop_list">
        <tbody>
        <c:forEach var="shop" items="${shops}" varStatus="status">
        <tr class="row${status.count % 2}">
        <th>店舗名</th>
        <td><c:out value="${shop.name}" /></td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>メールアドレス</th>
        <td><c:out value="${shop.email}" /></td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>電話番号</th>
        <td><c:out value="${shop.denwa}" /></td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>住所</th>
        <td><c:out value="${shop.address}" /></td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>エリア</th>
        <td>
        <c:if test="${shop.area == 1}">
        <c:out value="千住エリア" />
        </c:if>
        <c:if test="${shop.area == 2}">
        <c:out value="綾瀬エリア" />
        </c:if>
        <c:if test="${shop.area == 3}">
        <c:out value="六町エリア" />
        </c:if>
        <c:if test="${shop.area == 4}">
        <c:out value="梅島エリア" />
        </c:if>
        <c:if test="${shop.area == 5}">
        <c:out value="竹の塚エリア" />
        </c:if>
        </td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>情報</th>
        <td><pre><c:out value="${shop.info}" /></pre></td>
        </tr>
        <tr class="row${status.count % 2}">
        <th>編集</th>
        <td><a href="<c:url value='/shops/edit?id=${shop.id}'/>">お店情報を編集する</a>&nbsp;</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
<br/>
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
        </div><br />
        <a href="<c:url value='/menus/index' />">メニュー一覧へ戻る</a>&nbsp;
  </c:param>
</c:import>