<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Cart</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <br>

    <div class="container">
        <div class="row">
            <c:if test="${requestScope.errorMessage}">
                <p style="color: red;">${requestScope.errorMessage}</p>
            </c:if>
            <div class="col-md-8" id="cart">
                <section id="cart_items">
                    <div class="table-responsive cart_info">
                        <table class="table table-hover" id="myTable">
                            <thead>
                                <tr class="cart_menu bg-dark text-white">
                                    <td class="image">Item</td>
                                    <td>Description</td>
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
                </section>
                <!--/#cart_items-->
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-header"><h5 class="title">Cart Details</h5></div>
                    <div class="card-body">
                        <section id="do_action">
                            <div class="total_area cart_items">

                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                Cart Sub Total
                                            </div>
                                            <div>
                                                <span id="allCartTotal">0</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                Shipping Cost
                                            </div>
                                            <div>
                                                <span>Free</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                Total
                                            </div>
                                            <div>
                                                <span id="allCartTotalAfterShipping">0</span>
                                            </div>
                                        </div>
                                    </li>
                                    <c:if test="${!empty sessionScope.user}">
                                        <li class="list-group-item">
                                            <div class="d-flex justify-content-between">
                                                <div>
                                                    Balance
                                                </div>
                                                <div>
                                                    <span id="currentUserBalance">${sessionScope.user.balance}</span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </section>
                    </div>
                    <div class="card-footer bg-dark">
                        <div class="d-flex justify-content-between">
                            <div>
                                <a class="btn btn-danger text-white update removeAll">Clear</a>
                            </div>
                            <div>
                                <a class="btn btn-success text-white check_out" data-toggle="modal" data-target="#myModel"
                                   onclick="checkOut('${sessionScope.user.userId}')">Check Out</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="myModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Sorry</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <h6>no items in the cart.. <img src="images/cart/emoji.jpg" style="width: 50px; height: 50px"></h6>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4" id="response">
                <p id="response_message">dummy message</p>
            </div>
        </div>

    </div>

    <br>

    <%@include file="includes/footer.jsp" %>
    <script src="scripts/cart.js"></script>
</body>

</html>