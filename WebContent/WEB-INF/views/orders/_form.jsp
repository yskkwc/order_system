<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${errors != null}">
  <div id="flush_error">
    入力内容にエラーがあります。<br />
    <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
      <br />
    </c:forEach>

  </div>
</c:if>
<br />
<h3>注文メニュー</h3>
<br />
<label for="menu_name">メニュー名</label>
<br />
<input type="text" name="menu_name" value="${menu.name}" />
<br />
<br />

<label for="price">値段</label>
<br />
<input type="number" name="price" value="${menu.price}" />
円
<br />
<br />

<label for="content">個数の選択</label>
<br />
<input type="number" name="number" value="1" />
個
<br />
<br />
<br />
<br />

<h3>お客様情報の入力</h3>
<br />
<label for="name">お名前</label>
<br />
<input type="text" name="name" />
<br />
<br />

<label for="address">おところ</label>
<br />
<input type="text" name="address" size="40" />
<br />
<br />

<label for="denwa">お電話番号</label>
<br />
<input type="tel" name="denwa" size="40" />
<br />
<br />

<input type="hidden" name="_token" value="${_token}" />
<a href="#" onclick="confirmOrder();"><button type="submit">注文する</button></a>