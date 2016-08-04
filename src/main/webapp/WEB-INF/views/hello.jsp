<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head><title>GFI Academy</title></head>
<body>
<h2>Hello World!</h2>

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

</body>
</html>