<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List</title>
</head>
<body>

<div>
<table>

    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>

    <c:forEach var = "employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstname}</td>
            <td>${employee.lastname}</td>
            <td><a href="${pageContext.request.contextPath}/delete?id=${employee.id}&firstname=${employee.firstname}&lastname=${employee.lastname}">Delete</a></td>
            <td><a href="${pageContext.request.contextPath}/jsps/employeeupdate.jsp?id=${employee.id}&firstname=${employee.firstname}&lastname=${employee.lastname}">Update</a></td>
        </tr>
    </c:forEach>

</table>

</div>

    <div>
        <c:if test="${deleteAPIError}">
            <p>Something went wrong with Delete</p>
        </c:if>  
    </div>

    <div>
        <c:if test="${updateAPIError}">
            <p>Something went wrong with Update</p>
        </c:if>  
    </div>


</body>
</html>