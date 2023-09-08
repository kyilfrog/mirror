<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>비밀번호 찾기</title>
</head>
<body>
    <form action="/user/resetPassword" method="post">
        아이디: <input type="text" name="username"><br>
        이메일: <input type="text" name="email"><br>
        <input type="submit" value="비밀번호 재설정">
    </form>
</body>
</html>
