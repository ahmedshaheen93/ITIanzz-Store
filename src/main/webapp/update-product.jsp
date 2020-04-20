<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${applicationScope.storeInstance.storeName} - Update Product</title>
    <%@ include file="includes/head.jsp" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<header>

    <%@include file="includes/header.jsp" %>
    <link href="styles/now-ui-dashboard.css?v=1.5.0" rel="stylesheet">
    <link href="styles/demo.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/profile-style.css">
    <link rel="stylesheet" href="styles/product-images-style.css">
</header>
<div class="wrapper">
    <div class="content" style="width: 85%; height: 60%; margin-left: 80px">
        <div class="row">
            <div class="card" style="margin: 5px">
                <div class="card-header">
                    <h5 class="title">update Product</h5>
                </div>
                <div class="card-body">
                    <form id="updateProduct" action="update-product" enctype="multipart/form-data"
                          method="post">
                        <div class="row">
                            <div class="form-group">
                                <label class="col control-label" for="productName">Product Name</label>
                                <div class="col">
                                    <input type="hidden" id="productId" name="productId"
                                           value="${requestScope.product.productId}">
                                    <input id="productName" name="productName" placeholder="Product Name"
                                           class="form-control" type="text" required
                                           value="${requestScope.product.productName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="manufacturingName">Product Manufacture</label>
                                <div class="col">
                                    <input id="manufacturingName" name="manufacturingName"
                                           placeholder="Product Manufacture" class="form-control" type="text" required
                                           value="${requestScope.product.manufacturingName}">
                                </div>
                            </div>
                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col control-label" for="manufacturingDatepicker">Product Manufacturing
                                    Date</label>
                                <div class="col">
                                    <input class="form-control input-md" type="date"
                                           placeholder="Product Manufacturing Date" id="manufacturingDatepicker"
                                           required name="manufacturingDate"
                                           value="${requestScope.product.manufacturingDate}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="expiretionDatepicker">Product Expiration
                                    Date</label>
                                <div class="col">
                                    <input class="form-control input-md" type="date"
                                           name="expirationDate" placeholder="Product Expiration Date"
                                           id="expiretionDatepicker" required
                                           value="${requestScope.product.expirationDate}">
                                </div>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="row">
                            <div class="form-group">
                                <label class="col control-label" for="categories">Product Categories</label>
                                <div class="col">
                                    <div class="button-group">
                                        <button type="button" class="btn btn-default btn-sm dropdown-toggle"
                                                data-toggle="dropdown">
                                            Choose product categories
                                        </button>
                                        <ul class="dropdown-menu" id="categories">
                                            <c:if test="${!empty requestScope.product.categories}">
                                                <c:forEach items="${requestScope.allCategories}" var="cat">
                                                    <c:choose>
                                                        <c:when test="${requestScope.product.categories.contains(cat)}">
                                                            <li><input class="small" type="checkbox" name="categories"
                                                                       value="${cat.categoryId}"
                                                                       checked>&nbsp${cat.categoryName}</li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li><input class="small" type="checkbox" name="categories"
                                                                       value="${cat.categoryId}">
                                                                &nbsp;${cat.categoryName}</li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label"/>
                                <div class="col">
                                    <i type="button" class="btn btn-primary submit eatured-search-icon"
                                       data-toggle="modal" data-target="#productModal">
                                        add Category
                                    </i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="availableQuantity">Available Quantity</label>
                                <div class="col">
                                    <input id="availableQuantity" name="quantity"
                                           placeholder="AVAILABLE QUANTITY" class="form-control input-md"
                                           type="number"
                                           min="1"
                                           required value="${requestScope.product.quantity}">
                                </div>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="row">
                            <div class="form-group">
                                <label class="col control-label" for="buyPrice">Buy Price</label>
                                <div class="col">
                                    <input type="number" class="form-control" id="buyPrice"
                                           name="buyPrice" min="0" required/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="sellPrice">Sell Price</label>
                                <div class="col">
                                    <input type="number" class="form-control" id="sellPrice"
                                           name="sellPrice" min="0" required>
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <textarea cols="20" rows="3" name="description"></textarea>
                        </div>
                        <div class="wrapper">
                            <div class="row">

                                <div class="container1">
                                    <p>primary image</p>
                                    <img id="image1" alt="image" class="image" style="width:100%; display: none">
                                    <div class="middle">
                                        <label for="1" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                           aria-hidden="true">upload</i>
                                        </label>
                                        <input type="file" name="file" id="1" onchange="readURL(this)"
                                               required>
                                    </div>
                                </div>
                                <div class="container1">
                                    <img id="image2" alt="image" class="image" style="width:100%; display: none">
                                    <div class="middle">
                                        <label for="2" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                           aria-hidden="true">upload</i>
                                        </label>
                                        <input type="file" id="2" name="file" onchange="readURL(this)">
                                    </div>
                                </div>
                                <div class="container1">
                                    <img id="image3" alt="image" class="image" style="width:100%; display: none">
                                    <div class="middle">
                                        <label for="3" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                           aria-hidden="true">upload</i>
                                        </label>
                                        <input type="file" id="3" name="file" onchange="readURL(this)">
                                    </div>
                                </div>
                                <div class="container1">
                                    <img id="image4" alt="image" class="image" style="width:100%; display: none">
                                    <div class="middle">
                                        <label for="4" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                           aria-hidden="true">upload</i>
                                        </label>
                                        <input type="file" id="4" name="file" onchange="readURL(this)">
                                    </div>
                                </div>
                                <div class="container1">
                                    <img id="image5" alt="image" class="image" style="width:100%; display: none">
                                    <div class="middle">
                                        <label for="5" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                           aria-hidden="true">upload</i>
                                        </label>
                                        <input type="file" name="file" id="5" onchange="readURL(this)">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Button -->
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="submit" class="btn btn-primary submit" value="update product">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="productModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!-- modal header -->
            <div class="modal-header">
                <h5 class="modal-title text-capitalize">Add category</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!--end of  modal header -->
            <!-- modal body -->
            <div class="modal-body">
                <div class="row">
                    <label for="categoryName" class="col control-label">Add Category</label>
                    <div class="col">
                        <input aria-invalid="categoryName" type="text" name="categoryName" class="form-control"
                               id="categoryName">
                    </div>

                </div>
            </div>
            <!-- end modal body -->
            <div class="modal-footer">
                <button class="btn btn-danger my-2 mx-2 addCategory" data-dismiss="modal">add Category</button>
            </div>
        </div>
    </div>
</div>

<%--<footer>
    <%@include file="includes/footer.jsp" %>
</footer>--%>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="scripts/update-product.js"></script>
</html>