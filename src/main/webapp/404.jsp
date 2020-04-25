<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="product" uri="/tlds/productTagLib" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Products</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
<header>
    <%@include file="includes/header.jsp" %>
</header>

<div class="container-fluid">
    <h1>404</h1>
    <p>page not found</p>
    <a href="/iti-store/home">back to home</a>
</div>

<%@include file="includes/footer.jsp" %>
</body>

</html>
