<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Soft UI - Neumorphism Style UI Kit">
<meta name="author" content="kingstudio.ro">
<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/assets/images/favicon.png">
<!-- Site Title -->
<title>비밀번호 초기화</title>
<!-- Bootstrap 4 core CSS -->
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom Styles -->
<link href="${pageContext.request.contextPath}/assets/css/animate.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/style.css"
	rel="stylesheet">
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;600;800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;600;800&display=swap"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/css/fontawesome-all.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/login-register.css"
	rel="stylesheet">
</head>

<body>

	<div id="preloader">
		<div class="preloader">
			<span></span> <span></span>
		</div>
	</div>

	<a href="${pageContext.request.contextPath}/index.html"
		class="top-logo"><img
		src="${pageContext.request.contextPath}/assets/images/logo-main.png"
		alt=""></a>

	<div class="full-height relative p-y-30 v-center bg-img"
		style="background-image: url(${pageContext.request.contextPath}/assets/images/placeholder.jpg)">
		<div class="container p-y-70">
			<div class="m-x-auto" style="max-width: 500px;">
				<div class="card mb-15">
					<div class="card-body p-x-25">
						<ul class="nav nav-tabs nav-pills text-center p-x-50"
							role="tablist">
							<li class="nav-item m-x-auto"><a
								class="nav-link active p-x-40" data-bs-toggle="tab"
								href="#tab-sign-in" role="tab"> <i
									class="fas fa-lock mr-5 va-middle"></i> <span class="va-middle">비밀번호
										초기화</span>
							</a></li>
						</ul>
						<form
							action="${pageContext.request.contextPath}/user/forgot-password"
							method="post">
							<!-- / nav tabs -->
							<div class="tab-content">
								<div class="tab-pane fade show active mt-20 p-15"
									id="tab-sign-in" role="tabpanel">
									<form class="validation-inner" id="findIdForm">
										<div class="form-group">
											<label for="userId">아이디:</label> <input type="text"
												class="form-control" name="userId" id="userId"
												placeholder="&#xf2bd; 아이디를 입력하세요"
												style="font-family: 'Font Awesome 5 Free', sans-serif !important; font-weight: 400">
										</div>
										<!-- / form-group -->
										<div class="form-group">
											<label for="email">이메일:</label> <input type="email"
												class="form-control" name="email" id="email"
												placeholder="&#xf2bd; 이메일을 입력하세요"
												style="font-family: 'Font Awesome 5 Free', sans-serif !important; font-weight: 400">
										</div>
										<div id="successMessage" class="message success"></div>

										<p class="message ${errorMessage != null ? 'error' : ''}">${errorMessage}</p>
										<p class="message ${successMessage != null ? 'success' : ''}">${successMessage}</p>

										<!-- / form-group -->

										<div class="row v-center mt-30">
											<div class="col-lg-5 tablet-lg-top-30">
												<!-- / checkbox -->
											</div>
											<!-- / column -->
											<div class="col-lg-7 text-right">
												<button type="submit"
													class="btn btn-sm btn-primary tablet-lg-fw">
													<i class="fas fa-sign-in-alt mr-5"></i> 비밀번호 초기화
												</button>
											</div>

											<!-- / column -->
										</div>
										<!-- / row -->
									</form>

									<!-- / column -->
								</div>
								<!-- / row -->
							</div>
						</form>
					</div>
					<!-- / tab-content -->
				</div>
				<!-- / card-body -->
			</div>
			<!-- / card -->
		</div>
	</div>

	<!-- / container -->
	<p class="absolute bottom-15 x-0 text-center">
		<a href="${pageContext.request.contextPath}/index.html"
			class="text-link fs-16 m-x-15">Home</a> <a
			href="${pageContext.request.contextPath}/components.html"
			class="text-link fs-16 m-x-15">Components</a> <a
			href="${pageContext.request.contextPath}/sections.html"
			class="text-link fs-16 m-x-15">Sections</a> <a
			href="${pageContext.request.contextPath}/templates.html"
			class="text-link fs-16 m-x-15">Templates</a>
	</p>


	<!-- core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- / core JavaScript -->

	<!-- preloader -->
	<script src="${pageContext.request.contextPath}/assets/js/preloader.js"></script>
	<!-- / preloader -->

	<!-- form validation -->


	<!-- end of custom script -->

</body>

</html>