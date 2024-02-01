<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<%-- login?result=error --%>
<%-- test 라는 값이 error 라면 ~ --%>
<%-- JSTL에서 param은 물음표 뒤에 있는 값을 가져온다. --%>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>

<form action="/login" method="post">
    <input type="text" name="mid">
<%--    <input type="password" name="mpw">--%>
    <input type="text" name="mpw">
    <input type="checkbox" name="auto">
    <button type="submit">LOGIN</button>
</form>
</body>
</html>