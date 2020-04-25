<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>${applicationScope.storeInstance.storeName} - Product</title>
    <%@include file="includes/head.jsp" %>
    <style>


        .text-center {
            text-align: center;
        }

        a {
            color: tomato;
            text-decoration: none;
        }

        a:hover {
            color: #2196f3;
        }

        pre {
            display: block;
            padding: 9.5px;
            margin: 0 0 10px;
            font-size: 13px;
            line-height: 1.42857143;
            color: #333;
            word-break: break-all;
            word-wrap: break-word;
            background-color: #F5F5F5;
            border: 1px solid #CCC;
            border-radius: 4px;
        }


        .header h2 {
            font-size: 3em;
            font-weight: 300;
            margin-bottom: 0.2em;
        }

        .header p {
            font-size: 14px;
        }


        #a-footer {
            margin: 20px 0;
        }

        .new-react-version {
            padding: 20px 20px;
            border: 1px solid #eee;
            border-radius: 20px;
            box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

            text-align: center;
            font-size: 14px;
            line-height: 1.7;
        }

        .new-react-version .react-svg-logo {
            text-align: center;
            max-width: 60px;
            margin: 20px auto;
            margin-top: 0;
        }


        .success-box {
            margin: 50px 0;
            padding: 10px 10px;
            border: 1px solid #eee;
            background: #f9f9f9;
        }

        .success-box img {
            margin-right: 10px;
            display: inline-block;
            vertical-align: top;
        }

        .success-box > div {
            vertical-align: top;
            display: inline-block;
            color: #888;
        }


        /* Rating Star Widgets Style */
        .rating-stars ul {
            list-style-type: none;
            padding: 0;

            -moz-user-select: none;
            -webkit-user-select: none;
        }

        .rating-stars ul > li.star {
            display: inline-block;

        }

        /* Idle State of the stars */
        .rating-stars ul > li.star > i.fa {
            font-size: 2.5em; /* Change the size of the stars */
            color: #ccc; /* Color on idle state */
        }

        /* Hover state of the stars */
        .rating-stars ul > li.star.hover > i.fa {
            color: #FFCC36;
        }

        /* Selected state of the stars */
        .rating-stars ul > li.star.selected > i.fa {
            color: #FF912C;
        }


    </style>
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
                        <div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails"
                             data-ride="carousel">

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
                                        <c:if test="${!empty requestScope.product.description}">
                                            <p>${requestScope.product.description}</p>
                                        </c:if>
                                        <c:if test="${empty requestScope.product.description}">
                                            <p>no description founded</p>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                            <!-- Accordion card -->

                            <!-- Accordion card -->
                            <div class="card">

                                <!-- Card header -->
                                <div class="card-header" role="tab" id="headingTwo2">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionEx"
                                       href="#collapseTwo2"
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
                <div class="card" id="newReview">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <form action="/iti-store/reviewProduct" method="post">
                                    <input type="hidden" name="productId" value="${requestScope.product.productId}">
                                    <textarea class="form-control" id="reviewMessage" cols="50" rows="5"
                                              name="reviewMessage"></textarea>
                                    <section class='rating-widget'>

                                        <!-- Rating Stars Box -->
                                        <div class='rating-stars text-center'>
                                            <ul id='stars'>
                                                <li class='star' title='Poor' data-value='1'>
                                                    <i class='fa fa-star fa-fw'></i>
                                                </li>
                                                <li class='star' title='Fair' data-value='2'>
                                                    <i class='fa fa-star fa-fw'></i>
                                                </li>
                                                <li class='star' title='Good' data-value='3'>
                                                    <i class='fa fa-star fa-fw'></i>
                                                </li>
                                                <li class='star' title='Excellent' data-value='4'>
                                                    <i class='fa fa-star fa-fw'></i>
                                                </li>
                                                <li class='star' title='WOW!!!' data-value='5'>
                                                    <i class='fa fa-star fa-fw'></i>
                                                </li>
                                            </ul>
                                        </div>
                                    </section>


                                    <input type="hidden" name="reviewStars" class="reviewStars" min="1" max="5">
                                    <button class="btn btn-primary btn-md my-0 p pull-right" type="submit"
                                            style="border-radius: 20px">add review
                                        <i class="fas fa-reply ml-1"></i>
                                    </button>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- End Product Review card -->
                <c:if test="${!empty requestScope.product.reviews}">
                    <c:forEach var="review" items="${requestScope.product.reviews}">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img src="${review.imagePath}"
                                             alt=""
                                             class="img img-rounded img-fluid">
                                        <p class="text-secondary text-center">${review.reviewMessageTime}</p>
                                    </div>
                                    <div class="col-md-10">
                                        <p>
                                            <a class="float-left"><strong>${review.userName}</strong></a>

                                            <c:forEach begin="1" end="5" varStatus="loop">
                                                <c:choose>
                                                    <c:when test="${loop.index le review.reviewStars}">
                                                    <span class="float-right"><i
                                                            class="text-warning fa fa-star"></i></span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="float-right"><i class="fa fa-star"></i></span>
                                                    </c:otherwise>
                                                </c:choose>

                                            </c:forEach>
                                        </p>
                                        <div class="clearfix"></div>
                                        <p>${review.reviewMessage}</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%--                        <div class="row" style="width: 100%">--%>

                        <%--                            <div class="card text-center mx-5 mt-1">--%>
                        <%--                                <div class="row no-gutters">--%>
                        <%--                                    <div class="col  m-auto ">--%>
                        <%--                                        <c:choose>--%>
                        <%--                                            <c:when test="${sessionScope.user.userImage != null}">--%>
                        <%--                                                <img src="/iti-store/images?imageId=${review.user.userImage.imageId}"--%>
                        <%--                                                     alt=""--%>
                        <%--                                                     class="align-bottom" style="width: 100%; height: 100%;">--%>
                        <%--                                            </c:when>--%>
                        <%--                                            <c:otherwise>--%>
                        <%--                                                <img src="images/user/avatar.jpg" alt=""--%>
                        <%--                                                     class="align-bottom" style="width: 100%; height: 100%;">--%>
                        <%--                                            </c:otherwise>--%>
                        <%--                                        </c:choose>--%>

                        <%--                                    </div>--%>
                        <%--                                    <div class="col">--%>
                        <%--                                        <div class="card-body">--%>
                        <%--                                            <h5 class="card-title">${review.userName}</h5>--%>
                        <%--                                            <p class="card-text">${review.reviewMessage}</p>--%>
                        <%--                                            <p class="card-text"><small--%>
                        <%--                                                    class="text-muted">${review.reviewMessageTime}</small>--%>
                        <%--                                            </p>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                    </c:forEach>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>product not found !!</h2>
            </c:otherwise>
        </c:choose>
    </div>
</section>

<%@include file="includes/footer.jsp" %>
<script src="scripts/product.js"></script>
<script>
    $(document).ready(function () {

        /* 1. Visualizing things on Hover - See next part for action on click */
        $('#stars li').on('mouseover', function () {
            var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

            // Now highlight all the stars that's not after the current hovered star
            $(this).parent().children('li.star').each(function (e) {
                if (e < onStar) {
                    $(this).addClass('hover');
                } else {
                    $(this).removeClass('hover');
                }
            });

        }).on('mouseout', function () {
            $(this).parent().children('li.star').each(function (e) {
                $(this).removeClass('hover');
            });
        });


        /* 2. Action to perform on click */
        $('#stars li').on('click', function () {
            var onStar = parseInt($(this).data('value'), 10); // The star currently selected
            var stars = $(this).parent().children('li.star');

            for (i = 0; i < stars.length; i++) {
                $(stars[i]).removeClass('selected');
            }

            for (i = 0; i < onStar; i++) {
                $(stars[i]).addClass('selected');
            }

            // JUST RESPONSE (Not needed)
            var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
            $(".reviewStars").val(ratingValue);
            var msg = "";
            if (ratingValue > 1) {
                msg = "Thanks! You rated this " + ratingValue + " stars.";
            } else {
                msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
            }
            responseMessage(msg);

        });

    });


    function responseMessage(msg) {
        $('.success-box').fadeIn(200);
        $('.success-box div.text-message').html("<span>" + msg + "</span>");
    }
</script>
</body>
</html>
