<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${applicationScope.storeInstance.storeName} - Add Product</title>
    <%@ include file="includes/head.jsp" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
        .thumbnail {
            height: 100px;
            margin: 10px;
        }
    </style>
</head>


<body>
<header>
    <%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="styles/profile-style.css">
    <link href="styles/now-ui-dashboard.css?v=1.5.0" rel="stylesheet">
    <link href="styles/demo.css" rel="stylesheet">
</header>
<div class="wrapper">
    <div class="content" style="width: 80%; height: 60%; margin-left: 110px">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h5 class="title">Add Product</h5>
                    </div>
                    <div class="card-body">
                        <form id="addProductForm" action="/iti-store/addProduct" enctype="multipart/form-data"
                              method="post">
                            <div class="row">
                                <label class="col control-label" for="productName">Product Name</label>
                                <div class="col">
                                    <input id="productName" name="productName" placeholder="Product Name"
                                           class="form-control" type="text" required
                                           value="${requestScope.product.productName}">
                                </div>
                                <label class="col control-label" for="manufacturingName">Product Manufacture</label>
                                <div class="col">
                                    <input id="manufacturingName" name="manufacturingName"
                                           placeholder="Product Manufacture" class="form-control" type="text" required>
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="row">

                                <label class="col control-label" for="manufacturingDatepicker">Product Manufacturing
                                    Date</label>
                                <div class="col">
                                    <input class="form-control input-md manDate" type="text"
                                           placeholder="Product Manufacturing Date" id="manufacturingDatepicker"
                                           required name="manufacturingDate"><br/>
                                    <label id="manufacturingDateValidationError"></label>
                                </div>
                                <label class="col control-label" for="expiretionDatepicker">Product Expiration Date</label>
                                <div class="col">
                                    <input class="form-control input-md exDate" type="text"
                                           name="expirationDate" placeholder="Product Expiration Date"
                                           id="expiretionDatepicker" required><br>
                                    <label id="expiretionDateValidationError"></label>
                                </div>

                            </div>

                            <!-- Text input-->
                            <div class="row">
                                <label class="col control-label " for="categories">Product Categories</label>
                                <div class="col">
                                    <select id="categories" name="categories" class="form-control">
                                        <c:if test="${!empty requestScope.allCategories}">
                                            <c:forEach items="${requestScope.allCategories}" var="cat">
                                                <option value="${cat.categoryId}">${cat.categoryName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <label class="col control-label" for="availableQuantity">AVAILABLE QUANTITY</label>
                                <div class="col">
                                    <input id="availableQuantity" name="quantity"
                                           placeholder="AVAILABLE QUANTITY" class="form-control input-md" type="text"
                                           required>
                                </div>

                            </div>

                            <!-- Text input-->
                            <div class="row">
                                <label class="col control-label" for="buyPrice">Buy Price</label>
                                <div class="col">
                                    <input type="text" class="form-control" id="buyPrice"
                                           name="buyPrice"/>
                                </div>
                                <label class="col control-label" for="sellPrice">Sell Price</label>
                                <div class="col">
                                    <input type="text" class="form-control" id="sellPrice"
                                           name="sellPrice"/>
                                </div>
                            </div>
                            <div class="container">
                                <textarea cols="20" rows="10" name="description"></textarea>
                            </div>

                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <article>
                                            <label class="control-label" for="files">MAIN IMAGE</label>
                                            <input name="images" type='file' id="files" class="input-file"
                                                   accept="image/*" multiple/>
                                        </article>
                                    </div>
                                </div>
                            </div>
                            <!-- Button -->
                            <div class="form-group">
                                <div class="col">
                                    <button type="submit" class="btn btn-primary submit">add product</button>
                                    <i type="button" class="btn btn-primary submit eatured-search-icon" data-toggle="modal" data-target="#productModal">
                                        add Category
                                    </i>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" id="result"></div>
    </div>
</div>


<!-- Add Category Modal -->
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
                        <input aria-invalid="categoryName" type="text" name="categoryName" class="form-control" id="categoryName">
                    </div>

                </div>
            </div>
            <!-- end modal body -->
            <div class="modal-footer">
                <button class="btn btn-danger my-2 mx-2 addCatgry" data-dismiss="modal" >add Category</button>
               <%-- <button type="button" class="btn btn-danger " data-dismiss="modal">close modal</button>--%>
            </div>
        </div>
    </div>
</div>
<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="scripts/addProduct.js"></script>
</html>
