<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>맛집 리스트</title>
    <!-- Bootstrap CSS 추가 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">맛집 리스트</h1>
        
        <div class="row mt-4">
            <c:forEach items="${matzibList}" var="matzib">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="맛집 이미지 URL" class="card-img-top" alt="맛집 이미지">
                        <div class="card-body">
                            <h5 class="card-title">${matzib.title}</h5>
                            <p class="card-text">${matzib.description}</p>
                            <p class="card-text">카테고리: ${matzib.category}</p>
                            <p class="card-text">전화번호: ${matzib.telephone}</p>
                            <p class="card-text">주소: ${matzib.address}</p>
                            <a href="${matzib.link}" class="btn btn-primary" target="_blank">링크 보기</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Bootstrap JavaScript 및 jQuery 추가 (선택 사항) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
