<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="product" uri="/tlds/productTagLib" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Products</title>
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
                    <div class="products-categories-title my-4">
                        <h6 class="text-uppercase">shop by categories</h6>
                        <div class="products-categories-underline"></div>
                    </div>
                    <!-- single link -->
                    <a href="#" class="d-block products-categories-link">
                        <p class="mb-0">kitchen</p>
                    </a>
                    <!-- end of single link -->
                    <!-- single link -->
                    <a href="#" class="d-block products-categories-link">
                        <p class="mb-0">bathroom</p>
                    </a>
                    <!-- end of single link -->
                    <!-- single link -->
                    <a href="#" class="d-block products-categories-link">
                        <p class="mb-0">living room</p>
                    </a>
                    <!-- end of single link -->
                    <!-- single link -->
                    <a href="#" class="d-block products-categories-link">
                        <p class="mb-0">bedroom</p>
                    </a>
                    <!-- end of single link -->
                    <!-- single link -->
                    <a href="#" class="d-block products-categories-link">
                        <p class="mb-0">patio</p>
                    </a>
                    <!-- end of single link -->
                    <!-- end of title -->
                    <div class="products-categories-title my-4">
                        <h6 class="text-uppercase">shop by price</h6>
                        <div class="products-categories-underline"></div>
                    </div>
                    <form>
                        <div class="form-group">
                            <label for="price-range">range : $0 - $1000</label>
                            <input type="range" name="price-range" class="form-control-range" id="price-range">
                        </div>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text form-icon">
                                    <i class="fa fa-search"></i>
                                </span>
                            </div>
                            <label>
                                <input type="text" class="form-control text-capitalize" placeholder="search by name">
                            </label>
                        </div>
                    </form>
                    <!-- end of title -->
                    <div class="products-categories-title my-4">
                        <h6 class="text-uppercase">shop by color</h6>
                        <div class="products-categories-underline"></div>
                    </div>
                    <!-- single color -->
                    <a href="#">
                        <p class="text-capitalize mb-0">
                            <span class="d-inline-block products-color products-color-black mr-2"></span>black (5)
                        </p>
                    </a>
                    <!-- end of single color -->
                    <!-- single color -->
                    <a href="#">
                        <p class="text-capitalize mb-0">
                            <span class="d-inline-block products-color products-color-red mr-2"></span>red (5)
                        </p>
                    </a>
                    <!-- end of single color -->
                    <!-- single color -->
                    <a href="#">
                        <p class="text-capitalize mb-0">
                            <span class="d-inline-block products-color products-color-blue mr-2"></span>blue (5)
                        </p>
                    </a>
                    <!-- end of single color -->
                    <!-- single color -->
                    <a href="#">
                        <p class="text-capitalize mb-0">
                            <span class="d-inline-block products-color products-color-yellow mr-2"></span>yellow (5)
                        </p>
                    </a>
                    <!-- end of single color -->
                    <!-- single color -->
                    <a href="#">
                        <p class="text-capitalize mb-0">
                            <span class="d-inline-block products-color products-color-green mr-2"></span>green (5)
                        </p>
                    </a>
                    <!-- end of single color -->
                    <!--  -->
                </div>
                <!-- product img -->
                <div class="col-10 col-md-7 col-lg-9 mx-auto my-3 ">
                    <div class="row">
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
                            <img src="images/home/img-products/product-1.png" class="img-fluid" alt="" />
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

    <%@include file="includes/footer.jsp" %>

</body>

</html>