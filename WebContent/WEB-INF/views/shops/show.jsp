<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
  <c:param name="content">
    <c:choose>
      <c:when test="${order != null}">
        <h2>
          <c:out value="${order.shop.name}" />
          様の受注メニュー
        </h2>
        <table class="order_menu">
          <tbody>
            <tr>
              <th class="order_date">受注時刻</th>
              <td class="order_date"><fmt:formatDate
                  value="${order.order_date}" pattern="yyyy/MM/dd kk:mm" /></td>
            </tr>
            <tr>
              <th class="order_name">注文メニュー</th>
              <td class="order_name"><c:out value="${order.menu.name}" /></td>
            </tr>
            <tr>
              <th class="order_number">注文個数</th>
              <td class="order_number">${order.number}</td>
            </tr>
            <tr>
              <th class="order_price">値段</th>
              <td class="order_price"><c:out value="${order.menu.price}" />円</td>
            </tr>
          </tbody>
        </table>
        <br />
        <br />

        <h2>お届け先詳細</h2>
        <table class="user_info">
          <tbody>
            <tr>
              <th class="user_name">注文者様氏名</th>
              <td class="user_name"><c:out value="${order.name}" /></td>
            </tr>
            <tr>
              <th class="user_address">注文者様住所</th>
              <td class="user_address"><c:out value="${order.address}" /></td>
            </tr>
            <tr>
              <th class="user_tel">電話番号</th>
              <td class="user_tel"><c:out value="${order.denwa}" /></td>
            </tr>
          </tbody>
        </table>
        <br />
        <br />
        <p>
          <a href="#" onclick="confirmDestroy();"><button type="button">受注完了処理</button></a>
        </p>
        <form method="POST" action="<c:url value='/shops/menudestroy' />">
          <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
          function confirmDestroy() {
            if (confirm("受注データを削除します。この操作は注文手続きが全て完了後に行ってください。")) {
              document.forms[0].submit();
            }
          }
        </script>
      </c:when>
      <c:otherwise>
        <h2>お探しのデータは見つかりませんでした。</h2>
      </c:otherwise>
    </c:choose>
    <p>
      <a href="<c:url value='/shops/receive' />">受注一覧に戻る</a>
    </p>
  </c:param>
</c:import>