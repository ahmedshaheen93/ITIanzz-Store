$(document).ready(
    function () {
        var productJSON = {
            categoryId: 0,
            min: 0,
            max: 0,
            productName: ""
        }

        var min = 0, max = 300;
        $("#slider-range").slider({
            range: true,
            min: 0,
            max: 500,
            values: [75, 300],
            option: "classes.ui-slider",
            slide: function (event, ui) {
                productJSON.min = ui.values[0];
                productJSON.max = ui.values[1];
                $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
            }
        });
        $("#amount").val("$" + $("#slider-range").slider("values", 0) +
            " - $" + $("#slider-range").slider("values", 1));


        $(".category p").click(function (event) {
            // $("#allProducts").empty();
            var catId = event.target.id;
            productJSON.categoryId = catId;
            /*jQuery.get("searchByCategory?categoryId=" + catId, function (data, status) {
                updateScene(data);
            });*/

        });

        $("#filterBtn").click(function () {
            productJSON.productName = $("#productName").val();
            $.ajax({
                type: "GET",
                url: "searchForProduct",
                dataType: "JSON",
                data: {message: JSON.stringify(productJSON)},
                statusCode: {
                    200: function (data) {
                        receiveMessage(data);
                    },
                    404: function () {
                        console.log("error")
                    }

                }
            })

            function receiveMessage(data) {
                console.log(data);
                updateScene(data);
            }

            /*$("#allProducts").empty();
            jQuery.get("searchByCategory?min=" + min +"&max=" +max , function (data, status) {
                updateScene(data);
            })*/
        });

        function updateScene(data) {
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
                    "                                <span class=\"featured-search-icon\" data-toggle=\"modal\" data-target=\"#productModal\">\n" +
                    "                                     <i class=\"fas fa-search\"></i>\n" +
                    "                                 </span>\n" +
                    "                                    <a href=\"#\" class=\"featured-store-link text-captilaze\">add to cart</a>\n" +
                    "                            </div>\n" +
                    "                            <h6 class=\"text-capitalize text-center my-2\">" + product.productName + "</h6>\n" +
                    "                            <h6 class=\"text-center\">\n" +
                    "                                <span>$ " + product.sellPrice + "</span>\n" +
                    "                            </h6>\n" +
                    "                        </div>"
                $("#allProducts").append(proDiv);
            })
        }
    })
