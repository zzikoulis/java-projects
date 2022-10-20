<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Updated</title>
</head>
<body>

    <h1>New Employee's Data:</h1>
    <p>Firstname: ${employee.firstname}</p>
    <p>Lastname: ${employee.lastname}</p>
    <a href="${pageContext.request.contextPath}/jsps/employeesmenu.jsp">Return to Main Menu</a>

</body>
</html>