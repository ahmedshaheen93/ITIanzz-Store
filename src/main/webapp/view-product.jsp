<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>product</title>
    <%@include file="includes/head.jsp" %>
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/templates/e-commerce/css/mdb.min.css">
</head>

<body class="product-v1 hidden-sn white-skin animated">
<header>
    <%@include file="includes/header.jsp" %>
</header>

<section id="productDetails" class="pb-5" style="width: 80%; margin-left: 100px">
    <!--News card-->
    <div class="card mt-5 hoverable">
        <div class="row mt-5">
            <c:choose>
                <c:when test="${!empty requestScope.product}">
                    <div class="col-lg-6">

                        <!--Carousel Wrapper-->
                        <div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails" data-ride="carousel">

                            <!--Slides-->
                            <div class="carousel-inner text-center text-md-left" role="listbox">
                                <div class="carousel-item active">
                                    <img src="${requestScope.product.primaryImage}" class="img-fluid"
                                         style="width: 576px; height: auto">
                                </div>
                                <c:forEach items="${requestScope.product.images}" var="image">
                                    <div class="carousel-item">
                                        <img src="${image}" class="img-fluid" style="width: 576px; height: auto">
                                    </div>
                                </c:forEach>
                            </div>
                            <!--/.Slides-->

                            <!--Thumbnails-->
                            <a class="carousel-control-prev" href="#carousel-thumb" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carousel-thumb" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                            <!--/.Thumbnails-->

                        </div>
                        <!--/.Carousel Wrapper-->
                    </div>
                    <div class="col-lg-5 mr-3 text-center text-md-left">
                        <h2 class="h2-responsive text-center text-md-left product-name font-weight-bold dark-grey-text mb-1 ml-xl-0 ml-4">
                            <strong>${requestScope.product.productName}</strong>
                        </h2>
                        <c:forEach items="${requestScope.product.categories}" var="category">
                    <span style="font-size: 15px"
                          class="badge badge-danger product mb-4 ml-xl-0 ml-4">${category}</span>
                        </c:forEach>
                        <h3 class="h3-responsive text-center text-md-left mb-5 ml-xl-0 ml-4">
              <span class="red-text font-weight-bold">
                <strong>${requestScope.product.price}$</strong>
              </span>
                        </h3>

                        <!--Accordion wrapper-->
                        <div class="accordion md-accordion" id="accordionEx" role="tablist" aria-multiselectable="true">

                            <!-- Accordion card -->
                            <div class="card">

                                <!-- Card header -->
                                <div class="card-header" role="tab" id="headingOne1">
                                    <a data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne1"
                                       aria-expanded="false" aria-controls="collapseOne1" class="collapsed">
                                        <h5 class="mb-0">
                                            Description
                                            <i class="fas fa-angle-down rotate-icon"></i>
                                        </h5>
                                    </a>
                                </div>

                                <!-- Card body -->
                                <div id="collapseOne1" class="collapse" role="tabpanel" aria-labelledby="headingOne1"
                                     data-parent="#accordionEx" style="">
                                    <div class="card-body">
                                            ${requestScope.product.description}
                                    </div>
                                </div>
                            </div>
                            <!-- Accordion card -->

                            <!-- Accordion card -->
                            <div class="card">

                                <!-- Card header -->
                                <div class="card-header" role="tab" id="headingTwo2">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionEx" href="#collapseTwo2"
                                       aria-expanded="false" aria-controls="collapseTwo2">
                                        <h5 class="mb-0">
                                            Details
                                            <i class="fas fa-angle-down rotate-icon"></i>
                                        </h5>
                                    </a>
                                </div>

                                <!-- Card body -->
                                <div id="collapseTwo2" class="collapse" role="tabpanel" aria-labelledby="headingTwo2"
                                     data-parent="#accordionEx" style="">
                                    <div class="card-body">
                                        <c:if test="${!requestScope.product.expirationDate.equals('')}">
                                            product expire date: ${requestScope.product.expirationDate}<br>
                                        </c:if>
                                        product manufacture: ${requestScope.product.manufacturingName} <br>
                                        product manufacture date: ${requestScope.product.manufacturingDate} <br>
                                    </div>
                                </div>
                            </div>
                            <!-- Accordion card -->
                        </div>
                        <!--/.Accordion wrapper-->

                        <!-- Add to Cart -->
                        <section class="color">
                            <div class="mt-5">

                                <div class="row mt-3 mb-4">
                                    <div class="col-md-12 text-center text-md-left text-md-right">
                                        <form class="d-flex justify-content-center">
                                            <!-- Default input -->
                                            <input type="number" value="1" aria-label="Search" class="form-control"
                                                   style="width: 100px">
                                            <c:if test="${!empty requestScope.product}">
                                                <a class="btn btn-primary btn-md my-0 p addToCart"  id="${requestScope.product.productId}" type="button"
                                                        style="border-radius: 20px">
                                                    Add to cart
                                                    <i class="fas fa-shopping-cart ml-1"></i>
                                                </a>
                                            </c:if>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- /.Add to Cart -->
                    </div>
                </c:when>
                <c:otherwise>
                    <h2>product not found !!</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<%@include file="includes/footer.jsp" %>
<script src="scripts/product.js"></script>
</body>
</html>
