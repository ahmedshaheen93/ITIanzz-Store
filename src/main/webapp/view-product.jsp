<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>product</title>
    <%@include file="includes/head.jsp" %>
</head>

<body class="product-v1 hidden-sn white-skin animated">
<header>
    <%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/templates/e-commerce/css/mdb.min.css">
</header>

<section id="productDetails" class="pb-5" style="width: 80%; margin-left: 100px">
    <!--News card-->
    <div class="card mt-5 hoverable">

        <c:choose>
            <c:when test="${!empty requestScope.product}">
                <div class="row mt-5">
                    <div class="col-lg-6">
                        <!--Carousel Wrapper-->
                        <div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails" data-ride="carousel">

                            <!--Slides-->
                            <div class="carousel-inner text-center text-md-left" role="listbox">
                                <div class="carousel-item active">
                                    <img src="${requestScope.product.primaryImage}" class="img-fluid"
                                         style="width: 500px; height: 500px">
                                </div>
                                <c:forEach items="${requestScope.product.images}" var="image">
                                    <div class="carousel-item">
                                        <img src="${image}" class="img-fluid" style="width: 500px; height: 500px">
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
                                            <input type="number" min="1" max="${requestScope.product.quantity}"
                                                   value="1" aria-label="Search" class="form-control"
                                                   style="width: 100px">
                                            <button id="${requestScope.product.productId}"
                                                    class="addToCart btn btn-primary btn-md my-0 p" type="button"
                                                    style="border-radius: 20px">
                                                Add to cart
                                                <i class="fas fa-shopping-cart ml-1"></i>
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- /.Add to Cart -->

                    </div>
                </div>
                <!-- Product Review card-->
                <div class="row">
                    <div class="card text-center mx-5 mt-1">
                        <div class="row no-gutters">
                            <div class="col-md-4  m-auto ">
                                <img src="images/products/man-one.jpg" alt="" class="align-bottom">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Amr ELbaz</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Product Review card    -->

                <!-- Product Review card-->
                <div class="row">
                    <div class="card text-center mx-5 mt-1">
                        <div class="row no-gutters">
                            <div class="col-md-4  m-auto ">
                                <img src="images/products/man-one.jpg" alt="" class="align-bottom">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Amr ELbaz</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Product Review card    -->

            </c:when>
            <c:otherwise>
                <h2>product not found !!</h2>
            </c:otherwise>
        </c:choose>
    </div>
</section>

<%@include file="includes/footer.jsp" %>
<script src="scripts/product.js"></script>

</body>
</html>
