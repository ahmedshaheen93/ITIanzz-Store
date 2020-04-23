<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Scratch Card Requests</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>
    <div class="container">

        <br>

        <div class="card">
            <div class="card-header">
                <h5 class="title">Scratch Cart Requests</h5>
            </div>
            <div class="card-body">

                <br>
                <c:if test="${requestScope.errorMessage}">
                    <p style="color: red;">${requestScope.errorMessage}</p>
                </c:if>
                <div class="col-12" id="cart">
                    <section id="cart_items">
                        <div class="table-responsive cart_info">
                            <table class="table table-hover" id="myTable">
                                <thead>
                                    <tr class="cart_menu">
                                        <td class="Name">Name</td>
                                        <td class="amount">Amount</td>
                                        <td class="time">Request Date</td>
                                        <td class="time">Request Time</td>
                                        <td class="operation">
                                            <div class="d-flex justify-content-center">Operation</div>
                                        </td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${!empty requestScope.approvedRequests}">
                                        <c:forEach items="${requestScope.approvedRequests}" var="scratchCardRequest">
                                            <tr>
                                                <td>${scratchCardRequest.user.firstName}
                                                    ${scratchCardRequest.user.lastName}
                                                </td>
                                                <td>${scratchCardRequest.amount}</td>
                                                <td>${scratchCardRequest.requestDateAndTime.toLocalDate()}</td>
                                                <td>${scratchCardRequest.requestDateAndTime.toLocalTime()}</td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                        <c:if test="${!scratchCardRequest.approved}">
                                                            <a class="btn btn-success text-white approveRequest"
                                                                name="${scratchCardRequest.scratchCardRequestId}">Approve
                                                                Request</a>
                                                            &nbsp; &nbsp;
                                                            <a class="btn btn-danger text-white deleteRequest"
                                                                name="${scratchCardRequest.scratchCardRequestId}">Discard</a>
                                                        </c:if>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </section>
                </div>

            </div>
        </div>

        <br>

    </div>

    <%@include file="includes/footer.jsp" %>
    <script src="scripts/requestBalance.js"></script>
</body>


</html>