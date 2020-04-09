<html>

<head>
    <title>Itinas Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet" />
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="styles/font-awesome.css" />
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <section class="container-fluid">
        <div class="row">
            <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel"
                data-pause=false>
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/home/slider/slider (1).jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>First slide label</h5>
                            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/home/slider/slider (2).jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Second slide label</h5>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/home/slider/slider (3).jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Third slide label</h5>
                            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </section>

    <br />

    <section>
        <div class="container-fluid">
            <div class="row home-filler align-items-end pb-5">
                <div class="col-10 mx-auto text-white text-center">
                    <h4 class="text-uppercase font-weight-bold">
                        smart furniture collection
                    </h4>
                    <p class="text-capitalize">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit,
                        iure?
                    </p>
                    <a href="#" class="text-weight-bold text-capitalize collection-link">
                        view collection
                    </a>
                    <div class="collection-underline"></div>
                </div>
            </div>
        </div>
    </section>
    <!-- end of home filler -->
    <!-- featured section -->
    <section class="featured py-5">
        <div class="container">
            <div class="row my-3">
                <div class="col-10 mx-auto text-center">
                    <h1 class="text-uppercase">featured products</h1>
                    <p class="text-muted">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora,
                        recusandae.
                    </p>
                </div>
            </div>
            <div class="row">
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-1.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-2.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-3.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-4.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-5.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
                <!-- single product -->
                <div class="col-10 mx-auto col-md-6 col-lg-4">
                    <div class="featured-container p-5">
                        <img src="images/home/img-products/product-6.png" class="img-fluid" alt="product" />
                        <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                            <i class="fas fa-search"></i>
                        </span>
                        <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                    </div>
                    <h6 class="text-capitalize text-center my-2">special product</h6>
                    <h6 class="text-center">
                        <span class="text-muted old-price mx-2">$200</span>
                        <span>$100</span>
                    </h6>
                </div>
                <!-- end single product -->
            </div>
        </div>
    </section>
    <!-- end of  featured section -->
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


    <footer id="footer">
        <%@include file="includes/footer.jsp" %>
    </footer>
</body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
<!-- script js -->
<script src="scripts/app.js"></script>

</html>