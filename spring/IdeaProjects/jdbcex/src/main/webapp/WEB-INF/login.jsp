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
<%-- test ��� ���� error ��� ~ --%>
<%-- JSTL���� param�� ����ǥ �ڿ� �ִ� ���� �����´�. --%>
<c:if test="${param.result == 'error'}">
    <h1>�α��� ����</h1>
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