<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/tlds/customer-custom-tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Customers</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="styles/customers-style.css">
        <link href="styles/now-ui-dashboard.css?v=1.5.0" rel="stylesheet">
        <link href="styles/demo.css" rel="stylesheet">
    </header>
<div class="customers">
    <div class="col-xl-8 col-md-6" style="margin-left: 280px;">
        <div class="card Recent-Users">
            <c:choose>
                <c:when test="${!empty requestScope.users}">
                    <div class="card-header">
                        <h5>Recent Users</h5>
                    </div>
                    <div class="card-block px-0 py-3">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tbody>
                                <c:forEach var="user" items="${requestScope.users}">
                                    <custom:customerCustomTag user="${user}"/>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-header">
                        <h5>no users yes!!</h5>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
    <%@include file="includes/footer.jsp" %>

</body>
</html>
