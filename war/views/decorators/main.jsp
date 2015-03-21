<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="author" content="Emanuel, Ewerton Costa, Pedro Almir e Wislanildo">
    	<meta name="description" content="Fuzzy Control System">
    	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">

    	<title>Fuzzy Control System</title>
    	
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" type="text/css" media="screen, projection">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stepform/step-form-wizard.css" type="text/css" media="screen, projection">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stepform/jquery.mCustomScrollbar.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/template/sticky-footer-navbar.css">

    	<script src="${pageContext.request.contextPath}/js/jquery/jquery-2.1.3.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/stepform/step-form-wizard.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/stepform/jquery.mCustomScrollbar.concat.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/bootstrap/docs.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/easing/jquery.easing.1.3.js"></script>
	    <script src="${pageContext.request.contextPath}/js/ejs/ejs_production.js"></script>
	    <script src="${pageContext.request.contextPath}/js/model/model.js"></script>

    	<style type="text/css">
	        pre {margin: 45px 0 60px;}
	        h2 {margin: 60px 0 30px 0;}
	        p {margin-bottom: 10px;}
	        .table {table-layout:fixed;}
	        .ellipsis {white-space: nowrap;overflow: hidden;text-overflow: ellipsis;}
	    </style>
  	</head>
  	<body>
  		<!-- Fixed navbar -->
    	<div class="navbar navbar-default navbar-fixed-top">
      		<div class="container">
        		<div class="navbar-header">
          			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	           			<span class="sr-only">Toggle navigation</span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
          			</button>
          			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Fuzzy Control System</a>
        		</div>
        		<div class="collapse navbar-collapse">
          			<ul class="nav navbar-nav">
            			<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
            			<li><a href="http://github.com/">Git Repository</a></li>
            			<li><a href="mailto:petrus.cc@gmail.com">Contact</a></li>
          			</ul>
        		</div><!--/.nav-collapse -->
      		</div>
    	</div>
		<div class="container" style="margin-top: 20px;">
    		<div class="site-index">
        		<div class="body-content">
        			<sitemesh:write property='body'/>
		            <footer class="footer">
		                <div class="container">
		                    <p class="text-muted">Developed by <a href="">Emanuel, Ewerton Costa, Pedro Almir e Wislanildo</a> © 2015</p>
		                </div>
		            </footer>
        		</div>
    		</div>
		</div>
  	
  	</body>
</html>