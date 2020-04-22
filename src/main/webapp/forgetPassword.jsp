<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/22/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forget Password</title>
</head>
<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>
    <c:if test="${!empty requestScope.errorMessage}">
        <p>${requestScope.errorMessage}</p>
    </c:if>
    <form method="post" action="/iti-store/forgetPassword">
        <input type="email" name="email">
        <input type="submit">
    </form>
    <footer>
        <%@include file="includes/footer.jsp" %>
    </footer>

</body>
</html>
