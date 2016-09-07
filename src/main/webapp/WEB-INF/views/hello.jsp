<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Message overview</h1>
<c:if test="${not empty message}">
	<p>${message}</p>
</c:if>

<c:if test="${not empty messages}">
	<h3>Message from the database</h3>
	<ul>
	<c:forEach items="${messages}" var="msg">
		<li>${msg.message}</li>
	</c:forEach>
	</ul>
</c:if>