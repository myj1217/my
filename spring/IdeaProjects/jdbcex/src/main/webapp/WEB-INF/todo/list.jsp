<%--
  Created by IntelliJ IDEA.
  User: EZEN305
  Date: 2024-01-31
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo List</h1>
<h2>${appName}</h2>
<%-- 진짜 받아오나 확인하기 위해서 --%>
<h2>${loginInfo}</h2>
<h3>${loginInfo.mname}</h3>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE" : "NOT YET" }</span>
        </li>
    </c:forEach>
</ul>
<%--action=? : ?에 해당하는 서블릿을 찾아라 (WebServlet)--%>
<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>
</body>
</html>
