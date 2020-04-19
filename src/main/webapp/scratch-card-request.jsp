<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Scratch Card Requests</title>
    <%@include file="includes/head.jsp" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="styles/cart.css" rel="stylesheet">
</head>

<body>
<header>
    <%@include file="includes/header.jsp" %>
</header>
<div class="container">
    <div class="row">
        <c:if test="${requestScope.errorMessage}">
            <p style="color: red;">${requestScope.errorMessage}</p>
        </c:if>
        <div class="col-8" id="cart">
            <section id="cart_items">
                <div class="table-responsive cart_info">
                    <table class="table table-condensed" id="myTable">
                        <thead>
                        <tr class="cart_menu">
                            <td class="Name">Name</td>
                            <td class="amount">Amount</td>
                            <td class="time">Request Time</td>
                            <td class="operation">Operation</td>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${!empty requestScope.approvedRequests}">
                            <c:forEach items="${requestScope.approvedRequests}" var="scratchCardRequest">
                                <tr>
                                    <td>${scratchCardRequest.user.firstName} ${scratchCardRequest.user.lastName}</td>
                                    <td>${scratchCardRequest.amount}</td>
                                    <td>${scratchCardRequest.requestDateAndTime}</td>
                                    <td>
                                        <c:if test="${!scratchCardRequest.approved}">
                                            <a class="btn btn-warning approveRequest"
                                               name="${scratchCardRequest.scratchCardRequestId}">approve</a>
                                            <a class="btn btn-danger deleteRequest"
                                               name="${scratchCardRequest.scratchCardRequestId}">delete</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </section> <!--/#cart_items-->
        </div>
        <div class="col-4" id="response">
            <p id="response_message">dummy message</p>
        </div>
    </div>

</div>

<%@include file="includes/footer.jsp" %>
<script src="scripts/requestBalance.js"></script>
</body>


</html>