$(document).ready(function () {

    var productJSON = {
        categoryId: 0,
        min: 0,
        max: 0,
        productName: ""
    }
    let maxPrice = $("#maxPrice").val();
    var min = 0;
    $("#slider-range").slider({
        range: true,
        min: 0,
        max: maxPrice,
        values: [0, maxPrice],
        option: "classes.ui-slider",
        slide: function (event, ui) {
            productJSON.min = ui.values[0];
            productJSON.max = ui.values[1];
            $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
        }
    });
    $("#amount").val("$" + $("#slider-range").slider("values", 0) +
        " - $" + $("#slider-range").slider("values", 1));


    $(".category  :input").click(function (event) {
        // $("#allProducts").empty();
        var catId = event.target.id;
        productJSON.categoryId = catId;
        /*jQuery.get("searchByCategory?categoryId=" + catId, function (data, status) {
            updateScene(data);
        });*/

    });

    $(".filterBtn").click(function () {
        let userRole = this.id;
        console.log("usereRole: " + userRole)
        productJSON.productName = $("#productName").val();
        console.log($("#productName").val())
        $.ajax({
            type: "GET",
            url: "searchForProduct",
            dataType: "JSON",
            data: {message: JSON.stringify(productJSON)},
            statusCode: {
                200: function (data) {
                    console.log(data)
                    receiveMessage(data, userRole);
                },
                404: function () {
                    console.log("error")
                }

            }
        });

        function receiveMessage(data, userRole) {
            console.log(data);
            updateScene(data, userRole);
        }

        /*$("#allProducts").empty();
        jQuery.get("searchByCategory?min=" + min +"&max=" +max , function (data, status) {
            updateScene(data);
        })*/
    });

//out.println("<button id=\"" + product.getProductId()+ "\" class=\"btn btn-primary updateProduct\" type=\"button\">Update Product</button>");
//                 out.println("<button id=\""+product.getProductId()+"\"class=\"btn btn-primary deleteProduct\" type=\"button\">Delete Product</button>");
    function updateScene(data, userRole) {
        $("#allProducts").empty();
        if (jQuery.isEmptyObject(data)) {
            var noData = "<p>No data founded </p>";
            $("#allProducts").append(noData);
        }
        data.forEach(product => {
            console.log(product);
            // product.primaryImage.imagePath
            var proDiv = "<div class=\"mx-auto col-md-6 col-lg-4\">\n" +
                "                            <div class=\"featured-container p-5\">\n" +
                "                                <img src=\"" + product.primaryImage + "\" class=\"img-fluid\" alt=\"product\" />\n" +
                "                                <span class=\"featured-search-icon\" >\n" +
                "                                     <i class=\"fas fa-search view-product\"></i>\n" +
                "                                 </span>\n" +
                "                                    <a href=\"#\" class=\"featured-store-link text-captilaze addToCart \" id=\"" + product.productId + "\">add to cart</a>\n" +
                "                            </div>\n" +
                "                            <h6 class=\"text-capitalize text-center my-2\">" + product.productName + "</h6>\n" +
                "                            <h6 class=\"text-center\">\n" +
                "                                <span>$ " + product.price + "</span>\n" +
                "                            </h6>\n";
            if (userRole == 'ADMIN_ROLE') {
                proDiv += `<button id="${product.productId}" class="btn btn-primary updateProduct xxx" type="button">Update Product</button>
                                <button id="${product.productId}"class="btn btn-primary deleteProduct" type="button">Delete Product</button>
                    </div>`;


            } else {
                proDiv += " </div>";
            }

            $("#allProducts").append(proDiv);
        })

        $(".updateProduct").on('click', function (event) {
            var productId = event.target.id;
            window.location.href = "update-product?id=" + productId;

        });


        $(".deleteProduct").on('click', function (event) {
            var productId = event.target.id;
            window.location.href = "deleteProduct?id=" + productId;
        });
    }

    $(".view-product").on('click', function (event) {

        var productId = $(this).parent().parent().find("a")[0].id;
        console.log("on view-product click " + productId);
        window.location.href = "view-product?id=" + productId;
    });

});

