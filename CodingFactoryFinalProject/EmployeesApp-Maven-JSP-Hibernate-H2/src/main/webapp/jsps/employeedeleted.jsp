<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Deleted</title>
</head>
<body>

    <p>Employee: { ${employee.id}, ${employee.firstname}, ${employee.lastname} } deleted successfully</p>
    <a href="${pageContext.request.contextPath}/jsps/employeesmenu.jsp">Return to Main Menu</a>

</body>
</html>