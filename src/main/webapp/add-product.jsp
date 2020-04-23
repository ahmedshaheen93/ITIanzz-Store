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
    </header>
    <div class="container">
        <br>
        <div class="card">
            <div class="card-header">
                <h5 class="title">Add New Product</h5>
            </div>
            <div class="card-body">
                <form id="addProductForm" action="/iti-store/addProduct" enctype="multipart/form-data" method="post">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="productName">Product Name</label>
                            <input id="productName" name="productName" placeholder="Product Name" class="form-control"
                                type="text" required value="${requestScope.product.productName}" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="manufacturingName">Product Manufacture</label>
                            <input id="manufacturingName" name="manufacturingName" placeholder="Product Manufacture"
                                class="form-control" type="text" required />
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="manufacturingDatepicker">Manufacturing
                                Date</label>
                            <input class="form-control input-md manDate" type="text"
                                placeholder="Product Manufacturing Date" id="manufacturingDatepicker" required
                                name="manufacturingDate">
                            <label id="manufacturingDateValidationError"></label>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="expiretionDatepicker">Expiration Date</label>
                            <input class="form-control input-md exDate" type="text" name="expirationDate"
                                placeholder="Product Expiration Date" id="expiretionDatepicker" required>
                            <label id="expiretionDateValidationError"></label>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="categories">Product Category</label>
                            <select id="categories" name="categories" class="form-control">
                                <c:if test="${!empty requestScope.allCategories}">
                                    <c:forEach items="${requestScope.allCategories}" var="cat">
                                        <option value="${cat.categoryId}">${cat.categoryName}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="availableQuantity">Quantity</label>
                            <input id="availableQuantity" name="quantity" placeholder="Quantity"
                                class="form-control input-md" type="text" required />
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="buyPrice">Buy Price</label>
                            <input type="text" class="form-control" id="buyPrice" name="buyPrice" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="sellPrice">Sell Price</label>
                            <input type="text" class="form-control" id="sellPrice" name="sellPrice" />
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="description">Description</label>
                            <textarea class="form-control" cols="50" rows="5" name="description"></textarea>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label class="control-label" for="files">Add Product Images</label>
                            <input name="images" type='file' id="files" class="input-file" accept="image/*" multiple />
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <button type="submit" class="btn btn-primary submit">Add Product</button>
                            <button type="button" class="btn btn-primary submit" data-toggle="modal"
                                data-target="#productModal">
                                Add Category
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

        <br>
        <div class="row" id="result"></div>
        <br>
    </div>


    <!-- Add Category Modal -->
    <div class="modal fade" id="productModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!-- modal header -->
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize">Add Category</h5>
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
                    <button class="btn btn-danger my-2 mx-2 addCatgry" data-dismiss="modal">Add Category</button>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <%@include file="includes/footer.jsp" %>
    </footer>
</body>
<script src="scripts/addProduct.js"></script>

</html>