<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="author" content="Pedro Almir" />
	<meta name="description" content="" />
	<title>Burndown System</title>
	
	<!-- Le styles -->
	<link href="css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="css/signin.css" media="screen" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container">
		<div class="row form-signin">
			<img alt="" src="${pageContext.request.contextPath}/images/FuzzyLogicLogo.png" />
		</div>
		
		<div class="row form-signin text-center">
				<a href="${loginURL}" class="btn btn-danger" style="width: 70%;">Entrar</a>
		</div>

		<footer class="login" style="margin-top: 100px">
			<div class="row"></div>
		</footer>
	</div>
</body>
</html>













