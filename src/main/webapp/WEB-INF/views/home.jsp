<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Welcome on the Academy Home Page</h1>
<div class="alert alert-info">
	<p>Trigger a <a href="<spring:url value="/hello"/>">message</a>!</p>
</div>