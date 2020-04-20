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


<!-- products -->
<section class="products">
    <div class="container-fluid">

        <div class="row">
            <!-- product info -->
            <div class="col-10 col-md-5 col-lg-3 mx-auto my-3 px-5 text-capitalize">
                <!-- categories -->
                <div class="row">
                    <div class="my-4">
                        <a class="label btn-secondary text-white" href="addProduct" style="padding: 10px; border-radius: 10px">
                            ADD NEW PRODUCT</a>
                    </div>
                </div>

                <div class="products-categories-title my-4">
                    <h6 class="text-uppercase">shop by categories</h6>
                    <div class="products-categories-underline"></div>
                </div>
                <!-- single link -->
                <c:if test="${!empty requestScope.categories}">
                    <c:forEach items="${requestScope.categories}" var="category">
                        <a class="d-block products-categories-link category">
                            <p id="${category.categoryId}" class="mb-0" hidden>${category.categoryName}</p>
                            <input id="${category.categoryId}" type="radio" name="gender" value="male">${category.categoryName}
                        </a>
                    </c:forEach>
                </c:if>


                <!-- end of single link -->
                <!-- end of title -->
                <div class="products-categories-title my-4">
                    <h6 class="text-uppercase">shop by price</h6>
                    <div class="products-categories-underline"></div>
                </div>
                <form>
                    <div class="form-group">
                        <p>
                            <label for="amount">Price range:</label>
                            <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
                        </p>
                        <div id="slider-range"></div>
                    </div>

                    <div class="input-group">
                        <div class="input-group-prepend">
                                <span class="input-group-text form-icon">
                                    <i class="fa fa-search"></i>
                                </span>
                        </div>
                        <label>
                            <input id="productName" type="text" class="form-control text-capitalize"
                                   placeholder="search by name">
                        </label>
                    </div>
                    <button type="button" id="filterBtn">filter</button>
                </form>

                <!--  -->
            </div>
            <!-- product img -->
            <div class="col-10 col-md-7 col-lg-9 mx-auto my-3 ">
                <div class="row" id="allProducts">
                    <c:if test="${!empty requestScope.products}">
                        <c:forEach items="${requestScope.products}" var="product">
                            <product:productTLD product="${product}"></product:productTLD>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end of products -->

<%--
<nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-bottom navbar-toggleable-sm">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="navbar-buttons mbr-section-btn">
            <a class="btn btn-sm btn-black display-4" href="addProduct">
            ADD NEW PRODUCT</a>
        </div>
    </div>
</nav>
--%>
<!-- modal -->
<div class="modal fade" id="productModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!-- modal header -->
            <div class="modal-header">
                <h5 class="modal-title text-capitalize">product info</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!--end of  modal header -->
            <!-- modal body -->
            <div class="modal-body">
                <div class="row">
                    <div class="col text-center">
                        <img src="images/home/img-products/product-1.png" class="img-fluid" alt=""/>
                        <!-- ratings -->
                        <div class="ratings">
                            <span class="rating-icon"><i class="fas fa-star"></i></span>
                            <span class="rating-icon"><i class="fas fa-star"></i></span>
                            <span class="rating-icon"><i class="fas fa-star"></i></span>
                            <span class="rating-icon"><i class="fas fa-star"></i></span>
                            <span class="rating-icon"><i class="far fa-star"></i></span>
                            <span class="text-capitalize">(25 customer reviews)</span>
                        </div>
                        <!-- end of ratings -->
                        <h2 class="text-uppercase my-2">premium office armchair</h2>
                        <h2>$10.00 - $200.00</h2>
                        <p class="lead text-muted">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Commodi,
                            porro.
                        </p>
                        <!-- colors -->
                        <h5 class="text-uppercase">
                            colors :
                            <span class="d-inline-block products-color products-color-black mr-2"></span>
                            <span class="d-inline-block products-color products-color-red mr-2"></span>
                            <span class="d-inline-block products-color products-color-blue mr-2"></span>
                        </h5>
                        <!-- end of colors -->
                        <!-- sizes -->
                        <h5 class="text-uppercase">
                            sizes : <span class="mx-2">xs</span> <span class="mx-2">s</span>
                            <span class="mx-2">m</span> <span class="mx-2">l</span>
                            <span class="mx-2">xl</span>
                        </h5>
                        <div class="d-flex flex-wrap">
                            <!-- cart buttons -->
                            <div class="d-flex my-2">
                                <span class="btn btn-black mx-1">-</span>
                                <span class="btn btn-black mx-1">4</span>
                                <span class="btn btn-black mx-1">+</span>
                            </div>
                            <button class="btn btn-black my-2 mx-2">wishlist</button>
                            <button class="btn btn-yellow my-2 mx-2">add to cart</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end modal body -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">close modal</button>
            </div>
        </div>

    </div>
</div>

<footer id="footer">
    <%@include file="includes/footer.jsp" %>
    <script src="scripts/product.js"></script>
</body>

</html>