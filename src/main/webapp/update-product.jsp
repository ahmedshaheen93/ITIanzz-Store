<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update product</title>
    <%@ include file="includes/head.jsp" %>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<header>
    <%@include file="includes/header.jsp" %>
    <link href="styles/now-ui-dashboard.css?v=1.5.0" rel="stylesheet">
    <link href="styles/demo.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/profile-style.css">
</header>
<div class="wrapper">
    <div class="content" style="width: 85%; height: 60%; margin-left: 80px">
        <div class="row">
            <div class="card" style="margin: 5px">
                <div class="card-header">
                    <h5 class="title">update Product</h5>
                </div>
                <div class="card-body">
                    <form id="addProductForm" action="update-product" enctype="multipart/form-data"
                          method="post">
                        <div class="row">
                            <div class="form-group">
                                <label class="col control-label" for="productName">Product Name</label>
                                <div class="col">
                                    <input id="productName" name="productName" placeholder="Product Name"
                                           class="form-control" type="text" required
                                           value="${requestScope.product.productName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="manufacturingName">Product Manufacture</label>
                                <div class="col">
                                    <input id="manufacturingName" name="manufacturingName"
                                           placeholder="Product Manufacture" class="form-control" type="text" required>
                                </div>
                            </div>
                        <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col control-label" for="manufacturingDatepicker">Product Manufacturing
                                    Date</label>
                                <div class="col">
                                    <input class="form-control input-md" type="date"
                                           placeholder="Product Manufacturing Date" id="manufacturingDatepicker"
                                           required name="manufacturingDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col control-label" for="expiretionDatepicker">Product Expiration
                                    Date</label>
                                <div class="col">
                                    <input class="form-control input-md" type="date"
                                           name="expirationDate" placeholder="Product Expiration Date"
                                           id="expiretionDatepicker" required>
                                </div>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="row">
                            <label class="col control-label " for="categories">Product Categories</label>
                            <div class="col">
                                <select id="categories" name="categories" class="form-control">
                                    <c:if test="${!empty requestScope.allCategories}">
                                        <c:forEach items="${requestScope.allCategories}" var="cat">
                                            <option>${cat.categoryName}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                            <label class="col control-label" for="availableQuantity">Available Quantity</label>
                            <div class="col">
                                <input id="availableQuantity" name="quantity"
                                       placeholder="AVAILABLE QUANTITY" class="form-control input-md" type="number"
                                       min="1"
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
                            <div class="col-md-4">
                                <button type="submit" class="btn btn-primary submit">add product</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row" id="result"></div>
    </div>
</div>

<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</body>
</html>
--%>
