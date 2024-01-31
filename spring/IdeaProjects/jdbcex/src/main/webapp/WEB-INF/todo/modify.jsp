<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<form id="form1" action="/todo/modify" method="post">
    <div>
<%--        tno는 고유키, 식별자이기 때문에 바꾸면 안된다.--%>
<%--        따라서, readonly로 수정 못하게 막아놓음.--%>
        <input type ="text" name ="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        <input type ="text" name ="title" value="${dto.title}">
    </div>
    <div>
        <input type ="date" name ="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type ="checkbox" name ="finished" ${dto.finished ? "checked":""}>
    </div>
    <div>
        <button type="submit">Modify</button>
    </div>
</form>
<form id="form2" action="/todo/remove" method="post">
    <input type="hidden" name ="tno" value="${dto.tno}" readonly>
    <div>
        <button type="submit">Remove</button>
    </div>
</form>
</body>
</html>