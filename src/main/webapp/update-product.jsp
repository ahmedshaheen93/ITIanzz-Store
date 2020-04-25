<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>${applicationScope.storeInstance.storeName} - Update Product</title>
    <%@ include file="includes/head.jsp" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link href="https://formden.com/static/cdn/bootstrap-iso.css" rel="stylesheet">
    <style>

        img {
            max-width: 100px;
            max-height: 100px;
        }

        input[type=file] {
            width: 85px;
        }

        .container1 {
            position: relative;
            width: 15%;
            height: 150px;
            margin: 10px;
            background: white;
            text-align: center;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }

        p {
            -webkit-text-fill-color: #dadada;
        }

        .image {
            opacity: 1;
            display: block;
            width: 100%;
            height: auto;
            transition: .5s ease;
            backface-visibility: hidden;
        }

        .middle {
            transition: .5s ease;
            opacity: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%)
        }

        .container1:hover .image {
            opacity: 0.3;
        }

        .container1:hover .middle {
            opacity: 1;
        }

        .text {
            background-color: #709399;
            color: white;
            font-size: 13px;
            padding: 5px;
        }
    </style>
</head>

<body>
<header>
    <%@include file="includes/header.jsp" %>
</header>

<div class="container">
    <br>
    <div class="row">
        <div class="col-md-12">

            <div class="card">

                <div class="card-header">
                    <h5 class="title">Update Product Details</h5>
                </div>

                <div class="card-body">
                    <form id="updateProduct" action="/iti-store/update-product" enctype="multipart/form-data"
                          method="post">

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="productName">Product Name</label>
                                <input type="hidden" id="productId" name="productId"
                                       value="${requestScope.product.productId}">
                                <input id="productName" name="productName" placeholder="Product Name"
                                       class="form-control" type="text" required
                                       value="${requestScope.product.productName}"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="manufacturingName">Product Manufacture</label>
                                <input id="manufacturingName" name="manufacturingName"
                                       placeholder="Product Manufacture" class="form-control" type="text" required
                                       value="${requestScope.product.manufacturingName}"/>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="manufacturingDatepicker">Manufacturing
                                    Date</label>
                                <input class="form-control input-md manDate" type="text"
                                       placeholder="Product Manufacturing Date" id="manufacturingDatepicker" required
                                       name="manufacturingDate" value="${requestScope.product.manufacturingDate}"/>
                                <label id="manufacturingDateValidationError"></label>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="expiretionDatepicker">Expiration Date</label>
                                <input class="form-control input-md exDate" type="text" name="expirationDate"
                                       placeholder="Product Expiration Date" id="expiretionDatepicker" required
                                       value="${requestScope.product.expirationDate}"/>
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
                                <input id="availableQuantity" name="quantity"
                                       value="${requestScope.product.quantity}" class="form-control input-md"
                                       type="text" required/>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="buyPrice">Buy Price</label>
                                <input type="text" class="form-control" id="buyPrice" name="buyPrice"
                                       value="${requestScope.product.buyPrice}"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="sellPrice">Sell Price</label>
                                <input type="text" class="form-control" id="sellPrice" name="sellPrice"
                                       value="${requestScope.product.sellPrice}"/>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="description">Description</label>
                                <textarea class="form-control" cols="50" rows="5"
                                          name="description"
                                          id="description">${requestScope.product.description}</textarea>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="wrapper bootstrap-iso" style="width: 100%;">
                                <div class="row">
                                    <div class="container1">
                                        <p>primary image</p>
                                        <img id="image1" alt="image"
                                             src="/iti-store/images?imageId=${requestScope.product.primaryImage.imageId}"
                                             class="image" style="width:100%;">
                                        <div class="middle">
                                            <label for="1" class="btn-2 label-custom-style"><i class="fas fa-paperclip"
                                                                                               aria-hidden="true">upload</i>
                                            </label>
                                            <input type="file" name="images" id="1" onchange="readURL(this)"
                                                   required style="display: none;">
                                        </div>
                                    </div>
                                    <c:if test="${!empty requestScope.product.images}">
                                        <c:forEach items="${requestScope.product.images}" var="image">
                                            <c:if test="${requestScope.product.primaryImage.imageId != image.imageId}">
                                                <div class="container1">
                                                    <img id="image${image.imageId}" alt="image"
                                                         src="/iti-store/images?imageId=${image.imageId}"
                                                         class="image" style="width:100%;">
                                                    <div class="middle">
                                                        <label for="${image.imageId}"
                                                               class="btn-2 label-custom-style"><i
                                                                class="fas fa-paperclip"
                                                                aria-hidden="true">upload</i>
                                                        </label>
                                                        <input type="file" name="images" id="${image.imageId}"
                                                               onchange="readURL(this)"
                                                               required style="display: none;">
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label class="control-label" for="files">Add Product Images</label>
                                <input name="images" type='file' id="files" class="input-file" onchange="validateNumberOFiles(this.files.length, 5-${requestScope.product.images.size()})" accept="image/*" multiple/>
                            </div>
                        </div>
                        <br>
                        <div class="form-row" id="result"></div>
                        <br>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <button type="submit" id="updateBtn" class="btn btn-primary submit">Update
                                    Product
                                </button>
                                <button type="button" class="btn btn-primary submit"
                                        data-toggle="modal"
                                        data-target="#productModal">
                                    Add Category
                                </button>
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>
    <br>
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
<div class="modal fade" id="filesValidator" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">

        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title text-capitalize">Warning!!</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                sorry, you can't upload more than 5 images..
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</body>

<script src="scripts/update-product.js"></script>
</html>