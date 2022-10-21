<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Update Employee Form</title>
</head>
<body>

    <div>
        <form method="GET" action="${pageContext.request.contextPath}/update">
            <input type="text" name="id" value="${param.id}" readonly><br>
            <input type="text" name="firstname" value="${param.firstname}"><br>
            <input type="text" name="lastname" value="${param.lastname}"><br><br>
            <button type="submit">Update Employee</button>
        </form>
    </div>

    <br>
    <a href="${pageContext.request.contextPath}/jsps/employeesmenu.jsp">Return to Main Menu</a>

</body>
</html>