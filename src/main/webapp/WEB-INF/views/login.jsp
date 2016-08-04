<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
	<title>GFI Academy - Authentication</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">	
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4">		
			<h2>Please authenticate</h2>
			
			<c:if test="${param.error ne null}">
				<div class="alert alert-error">Invalid username and password.</div>
			</c:if>
			
			<c:if test="${param.logout ne null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
			
			<form action="login" method="post">
			  <div class="form-group">
			    <label for="username">Username</label>
			    <input type="text" class="form-control" id="username" name="username" placeholder="Username">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Password</label>
			    <input type="password" class="form-control" id="pwd" name="password" placeholder="Password">
			  </div>	 
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			  <button type="submit" class="btn btn-default">Sign in</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>