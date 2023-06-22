<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Suraj">
    <!--meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_header" th:content="${_csrf.headerName}"/-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/core/bootstrap-5.min.css"  type="text/css" />
    <link rel="stylesheet" href="/resources/css/custom.css" type="text/css" />
    <link rel="stylesheet" href="/resources/css/core/flag-icon.min.css" type="text/css" />
    <title>Welcome</title>
    <script type="text/javascript" src="/resources/js/navbar-scripts.js"></script>
</head>
<body>
	<div>
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position: relative;">
			    <div class="container-fluid">
			        <a class="navbar-brand" href="#" onclick="goToHome();" >
			            <h2><b>조달구매시스템</b></h2>
			        </a>
			    </div>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="position: absolute; left: 250px; top: 40px;">
			
			    </div><!--/.nav-collapse -->
			</nav>
			<div class="area"></div>
			<nav class="main-menu">
			    
			</nav>
			<br />
		</div>
	</div>
	<div class="container" style="position: absolute; left: 250px; top: 200px; 3000px;">
	    <div class="wrap">
	        <div class="row g-3">
	            <div class="col-md-3">
	                <button class="mybtn">조달 관리</button>
	            </div>
	            <div class="col-md-3">
	                <button class="mybtn">발주 관리</button>
	            </div>
	            <div class="col-md-3">
	                <button class="mybtn" onclick="location.href='stockmanagement/inbound'">자재 관리</button>
	            </div>
	        </div>
	    </div>
	</div>
    <script src="/resources/js/core/popper.min.js" type="text/javascript"></script>
    <script src="/resources/js/core/bootstrap-5.min.js" type="text/javascript"></script>
</body>
</html>