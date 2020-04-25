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

    <br>

    <div class="row">

        <div class="col-md-3">

            <div class="card text-center">
                <h5 class="card-header">Filter Products</h5>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item text-left">
                            <c:if test="${!empty requestScope.categories}">
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <a class="d-block products-categories-link category">
                                        <input id="${category.categoryId}" class="form-check-input" type="radio"
                                               name="gender" value="male">
                                        <label class="form-check-label" for="${category.categoryId}">
                                                ${category.categoryName}
                                        </label>
                                    </a>
                                </c:forEach>
                            </c:if>
                        </li>
                        <li class="list-group-item">
                            <p><input type="text" id="amount" readonly
                                      style="border:0; font-weight:bold;"></p>
                            <div id="slider-range"></div>
                        </li>
                        <li class="list-group-item">
                            <input id="productName" type="text" class="form-control text-capitalize"
                                   placeholder="keyword">
                        </li>
                    </ul>
                </div>
                <div class="card-footer text-muted">
                    <button type="button" id='${sessionScope.user.role}' class="filterBtn btn btn-primary">Filter
                        Products
                    </button>
                    <input type="hidden" id="maxPrice" value="${requestScope.maxPrice}">
                    <a type="button" class="btn btn-danger" href="/iti-store/products">
                        Rest Filter
                    </a>
                </div>

            </div>

        </div>


        <div class="col-md-9">
            <div class="row" id="allProducts">
                <c:if test="${!empty requestScope.products}">
                    <c:forEach items="${requestScope.products}" var="product">
                        <product:productTLD product="${product}"></product:productTLD>
                    </c:forEach>
                </c:if>
            </div>
        </div>


    </div>
    <br>
</div>

<%@include file="includes/footer.jsp" %>
<script src="scripts/product.js"></script>
<script src="scripts/productSearch.js"></script>
</body>

</html>