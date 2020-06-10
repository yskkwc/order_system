<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="name">お店の登録名</label><br />
<input type="text" name="name" value="${shop.name}" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password" />
<br /><br />

<label for="email">メールアドレス</label><br />
<input type="email" name="email" value="${shop.email}" />
<br /><br />

<label for="denwa">電話番号</label><br />
<input type="tel" name="denwa" value="${shop.denwa}" />
<br /><br />

<label for="address">住所</label><br />
<input type="text" name="address" value="${shop.address}" />
<br /><br />

<select name="area">
  <option value="0">近い地域を選択してください</option>
  <option value="1">千住(せんじゅ)</option>
  <option value="2">綾瀬(あやせ)</option>
  <option value="3">六町(ろくちょう)</option>
  <option value="4">梅島(うめじま)</option>
  <option value="5">竹の塚(たけのづか)</option>
</select>
<br /><br />

<label for="info">備考欄</label><br />
<textarea id = "info" name="info" rows="10" cols="40">${shop.info}</textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>