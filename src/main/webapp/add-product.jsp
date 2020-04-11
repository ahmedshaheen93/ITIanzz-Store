<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/11/2020
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Product</title>
    <%@ include file="includes/head.jsp"%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
</head>

<body>
<header>
    <%@include file="includes/header.jsp"%>
</header>
<form class="container">
    <div class="row">
        <label class="col control-label" for="productName">PRODUCT NAME</label>
        <div class="col">
            <input id="productName" name="productName" placeholder="PRODUCT NAME" class="form-control"  type="text" required>
        </div>
        <label class="col control-label" for="productManufacture">PRODUCT MANUFACTURE</label>
        <div class="col">
            <input id="productManufacture" name="productManufacture" placeholder="PRODUCT MANUFACTURE" class="form-control"  type="text" required>
        </div>
    </div>

    <!-- Select Basic -->
    <div class="row">

        <label class="col control-label" for="manufacturingDatepicker">PRODUCT MANUFACTURING DATE</label>
        <div class="col">
            <input class="form-control input-md" type="text"  placeholder="PRODUCT MANUFACTURING DATE" id="manufacturingDatepicker" required>
        </div>
        <label class="col control-label" for="expiretionDatepicker">PRODUCT EXPIRATION DATE</label>
        <div class="col">
            <input class="form-control input-md" type="text" placeholder="PRODUCT EXPIRATION DATE" id="expiretionDatepicker" required>
        </div>
    </div>


    <!-- Text input-->
    <div class="row">
        <label class="col control-label " for="product_categorie">PRODUCT CATEGORY</label>
        <div class="col">
            <select id="product_categorie" name="product_categorie" class="form-control">
                <c:if test="${!empty requestScope.allCategories}">
                    <c:forEach items="${requestScope.allCategories}" var="cat">
                        <option>${cat.categoryName}</option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
        <label class="col control-label" for="availableQuantity">AVAILABLE QUANTITY</label>
        <div class="col">
            <input id="availableQuantity" name="availableQuantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md"  type="text" required>
        </div>

    </div>

    <!-- Text input-->
    <div class="row">
        <label class="col control-label" for="productBUYPrice">PRODUCT BUY PRICE</label>
        <div class="col">
            <input type="text" class="form-control" id="productBUYPrice" name="productBUYPrice"/>
        </div>
        <label class="col control-label" for="productSellPrice">PRODUCT SELL PRICE</label>
        <div class="col">
            <input type="text" class="form-control" id="productSellPrice" name="productSellPrice"/>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col">
                <label class="control-label" for="imgInp">MAIN IMAGE</label>
                <input type='file' id="imgInp" class="input-file" accept="image/*"/>
            </div>
            <div class="col">
                <label class="control-label" for="filebuttonAuxiliary">auxiliary_images</label>
                <input type='file' id="filebuttonAuxiliary" class="input-file" accept="image/*" multiple/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <img id="main_image" src="#" alt="your image"height="300px" width="100%" />
            </div>
            <div class="col">
                <img id="auxiliary_images" src="#" alt="your image"height="300px" width="100%"/>
            </div>
        </div>
    </div>




    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
        <div class="col-md-4">
            <button id="singlebutton" name="singlebutton" class="btn btn-primary">Button</button>
        </div>
    </div>
</form>
<footer>
    <%@include file="includes/footer.jsp"%>
</footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src = "scripts/addProduct.js"></script>
</html>
