<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="name">Menu名</label><br />
<input type="text" name="name" value="${menu.name}" />
<br /><br />

<label for="price">値段</label><br />
<input type="number" name="price" value="${menu.price}" />円
<br /><br />

<label for="content">Menuの説明</label><br />
<textarea name="content" rows="10" cols="50">${menu.content}</textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>