<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
<jsp:include page="/WEB-INF/views/tiles/header.jsp" />

<!-- / top -->
<div class="container">
    <h1 class="mt-5">맛집 리스트</h1>
    <hr>
	
    <div class="mb-4">
        <button class="btn btn-primary" data-category="한식">한식</button>
        <button class="btn btn-primary" data-category="일식">일식</button>
        <button class="btn btn-primary" data-category="중식">중식</button>
        <button class="btn btn-primary" data-category="양식">양식</button>
        <button class="btn btn-primary" data-category="기타">기타</button>
        <!-- 다른 카테고리 버튼들 추가 -->
    </div>
    <div class="row mt-4">
        <c:forEach items="${matzibList}" var="matzib" varStatus="loop">
            <div class="col-md-4 mb-4" data-category="${matzib.category_name.split(" > ")[1]}">
                <div class="card">
                    <div class="card-body">

                        <h5 class="card-title">${matzib.place_name}</h5>
                        <p class="card-text">카테고리: ${matzib.category_name.split(" > ")[1]}</p>
                        <p class="card-text">전화번호: ${matzib.phone}</p>
                        <p class="card-text">주소: ${matzib.address_name}</p>
                        <p class="card-text">x: ${matzib.x}</p>
                        <p class="card-text">y: ${matzib.y}</p>
                        <a href="#" class="btn btn-primary" data-toggle="modal"
                            data-target="#linkModal_${loop.index}">상세 정보 보기</a>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="linkModal_${loop.index}" tabindex="-1" role="dialog"
                aria-labelledby="linkModalLabel_${loop.index}" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="linkModalLabel_${loop.index}">상세 정보 보기</h5>
                            <button type="button" class="close" data-dismiss="modal"
                                aria-label="닫기">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <iframe src="${matzib.place_url}" width="1000" height="1000"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- footer 영역 추가-->
<jsp:include page="/WEB-INF/views/tiles/footer.jsp" />

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        // 초기에는 모든 업체가 보이도록 설정
        $(".col-md-4").show();

     // 카테고리 버튼 클릭 시 필터링
        $("button.btn-primary").click(function () {
            var category = $(this).data("category");

         // 기타 버튼을 클릭한 경우
            if (category === "기타") {
                // 한식, 일식, 중식, 양식을 제외한 업체만 표시
                $(".col-md-4[data-category!='한식'][data-category!='일식'][data-category!='중식'][data-category!='양식']").show();
            } else {
                // 모든 업체 숨기기
                $(".col-md-4").hide();

                // 선택한 카테고리의 업체만 표시
                $(".col-md-4[data-category='" + category + "']").show();
            }
        });
    });
</script>
</body>
</html>

