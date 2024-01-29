<%--
  Created by IntelliJ IDEA.
  User: EZEN305
  Date: 2024-01-26
  Time: 오후 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp ${} <- el(expression language) 서버에서 데이터를 출력하는 용도.--%>
<%--param 이란 이름의 객체에 접근해서 현재 요청에 전달된 파라미터를 추출할 수 있다.--%>
<h1>NUM1 ${param.num1}</h1>
<h1>NUM2 ${param.num2}</h1>
<h1>SUM ${Integer.parseInt(param.num1)+Integer.parseInt(param.num2)}</h1>
</body>
</html>
