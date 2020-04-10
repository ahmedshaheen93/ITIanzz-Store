$(document).ready(
    function () {
        // $(".category p").click(
        //     function () {
        //         var catId = $(".category p").text();
        //         // var catId = $(this).getAttribute("id").valueOf();
        //         console.log(catId)
        //     }
        // )
        $(".category p").click(function (event) {
            $("#allProducts").empty();
            var catId = event.target.id;
            jQuery.get("searchByCategory?categoryId=" + catId, function (data, status) {
                data.forEach(product => {
                    console.log(product);
                    var proDiv = "<div class=\"mx-auto col-md-6 col-lg-4\">\n" +
                        "                            <div class=\"featured-container p-5\">\n" +
                        "                                <img src=\"" + product.primaryImage.imagePath + "\" class=\"img-fluid\" alt=\"product\" />\n" +
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

            });

        });
    })