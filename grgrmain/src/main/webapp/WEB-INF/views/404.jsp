<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Rise - Modern Bootstrap UI Kit">
<meta name="author" content="kingstudio.ro">
<!-- Favicon -->
<link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.png">
<!-- Site Title -->
<title>Rise - Modern Bootstrap UI Kit</title>
<!-- Bootstrap 4 core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom Styles -->
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Barlow:300,400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/fontawesome-all.min.css" rel="stylesheet"
	type="text/css">
</head>

<body>

	<div id="preloader">
		<div class="preloader">
			<span></span> <span></span>
		</div>
	</div>

	<div class="full-height v-center relative">
		<div class="container text-center relative z-index-1">
			<h2 class="pnf-page-title mb-30 d-block">Page Not Found</h2>
			<h6 class="mb-50 w-50 m-x-auto opc-5">죄송합니다. 요청하신 페이지가 없거나, 접근 권한이 없는 페이지 입니다.</h6>
			<button class="btn btn-primary mr-15" type="button"
				onclick="window.history.back();">
				<i class="fas fa-chevron-left va-middle mr-5"></i> <span>Go
					Back</span>
			</button>
			<a href="<c:url value='/main'/>"><i
				class="fas fa-home va-middle mr-5"></i> <span> Homepage</span></a>
		</div>
		<!-- / container -->
	</div>

	<!-- core JavaScript -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- / core JavaScript -->

	<!-- preloader -->
	<script src="${pageContext.request.contextPath}/assets/js/preloader.js"></script>
	<!-- / preloader -->

</body>

</html>

