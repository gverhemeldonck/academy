<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head><title>GFI Academy</title></head>
<body>
<h2>Hello World!</h2>

<c:if test="${not empty message}">
	<p>${message}</p>
</c:if>

</body>
</html>