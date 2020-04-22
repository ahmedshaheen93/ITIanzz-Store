<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Cart</title>
    <%@include file="includes/head.jsp" %>
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
                            <td class="image">Item</td>
                            <td class="description"></td>
                            <td class="price">Price</td>
                            <td class="quantity">Quantity</td>
                            <td class="total">Total</td>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody id="myTableBody">

                        </tbody>
                    </table>
                </div>
            </section> <!--/#cart_items-->
        </div>
        <div class="col-4" id="response">
            <p id="response_message">dummy message</p>
        </div>
        <div class="col-4">
            <section id="do_action">
                <div class="total_area cart_items">
                    <ul>
                        <li>Cart Sub Total <span id="allCartTotal">0</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span id="allCartTotalAfterShipping">0</span></li>
                        <c:if test="${!empty sessionScope.user}">
                            <li>Balance <span id="currentUserBalance">${sessionScope.user.balance}</span></li>
                        </c:if>
                    </ul>
                    <a class="btn btn-default update removeAll">Remove All</a>
                    <a class="btn btn-default check_out" onclick="checkOut('${sessionScope.user}')">Check Out</a>
                </div>
            </section>
        </div>
    </div>

</div>

<%@include file="includes/footer.jsp" %>
<script src="scripts/cart.js"></script>
</body>

</html>