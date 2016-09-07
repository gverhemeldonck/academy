<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
	<title><tiles:insertAttribute name="title"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<spring:url value="/static/css/main.css" var="mainCss"/>
	<link rel="stylesheet" href="${mainCss}">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		    <section id="sidemenu">
				<tiles:insertAttribute name="menu" />
		    </section>
    	</div>
    	<div class="col-md-8">
			<section id="site-content">
				<tiles:insertAttribute name="body" />
			</section>
		</div>
	</div>
	<div class="col-md-12">
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</div>
</body>
</html>