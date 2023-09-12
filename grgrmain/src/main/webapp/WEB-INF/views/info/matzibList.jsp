<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>맛집 리스트</title>
    <!-- Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="Soft UI - Neumorphism Style UI Kit" />
<meta name="author" content="kingstudio.ro" />
<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/assets/images/favicon.png" />
<!-- Site Title -->
<title>Soft UI - Neumorphism Style UI Kit</title>
<!-- Bootstrap 4 core CSS -->
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Custom Styles -->
<link href="${pageContext.request.contextPath}/assets/css/animate.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/assets/css/style.css"
	rel="stylesheet" />
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;600;800&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;600;800&display=swap"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/assets/css/fontawesome-all.min.css"
	rel="stylesheet" type="text/css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/tiles/header.jsp" />
	
	<!-- / top -->
    <div class="container">
        <h1 class="mt-5">맛집 리스트 </h1>
        <hr>
        
        <div class="row mt-4">
            <c:forEach items="${matzibList}" var="matzib">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <!--  <img src="${matzib.place_url}" class="card-img-top" alt="맛집 이미지">-->
                        <div class="card-body">
                            
                            <h5 class="card-title">${matzib.place_name}</h5>
                            <p class="card-text">카테고리: ${matzib.category_name}</p>
                            <p class="card-text">전화번호: ${matzib.phone}</p>
                            <p class="card-text">주소: ${matzib.address_name}</p>
                            <p class="card-text">x: ${matzib.x}</p>
                            <p class="card-text">y: ${matzib.y}</p>
                            <a href="${matzib.place_url}" class="btn btn-primary" target="_blank">링크 보기</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- footer 영역 추가--> 
	<jsp:include page="/WEB-INF/views/tiles/footer.jsp" />

    
</body>
</html>
