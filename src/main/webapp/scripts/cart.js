$(document).ready(function () {
    // get_AllProducts();
    onloadPage();

    // document ready => load from storage
    // JsonArray => storage ?

    // click on add to cart adding 
    // open cart => update qty
    //
    function get_AllProducts() {
        let allProducts = new Array;
        var products_str = localStorage.getItem('products');
        if (products_str !== null) {
            allProducts = JSON.parse(products_str);
            console.log(allProducts);
        }
        return allProducts;
    }

    function onloadPage() {
        var json = JSON.stringify(get_AllProducts());
        console.log("==========" + json);
        $.ajax({
            type: "POST",
            url: "products",
            dataType: "JSON",
            data: {products: json},
            statusCode: {
                200: function (data) {
                    console.log(data);
                    displayData(data);
                    calcTotal();
                },
                404: function () {
                    console.log("error")
                },
                500: function () {
                    alert("leh ya rb m 5k2tny4 m3za");
                }
            }
        })
        $("#response").hide();
    }

    function calcTotal() {
        var alltot = $(".totalPrice");
        var totalSum = 0;
        for (var i = 0; i < alltot.length; i++) {
            totalSum += parseFloat($(alltot[i]).text());
        }
        $("#allCartTotal").text(totalSum);
        $("#allCartTotalAfterShipping").text(totalSum);
        updateCartProducts();
    }


    function displayData(data) {
        data.forEach(row => {
            var insertedRow = `<tr class="rem1">
                            <td class="cart_product">
                                <a href=""><img src="images/cart/one.png" alt=""></a>
                            </td>
                            <td class="cart_description">
                                <h4><a href="">${row.productName}</a></h4>
                                <p>Web ID: <span class="productId">${row.productId}</span></p>
                            </td>
                            <td class="cart_price">
                                <p>${row.price}</p>
                            </td>
                            <td class="cart_quantity">
                                <div class="cart_quantity_button">
                                    <div class="value-minus">
                                        <a class="cart_quantity_down"> - </a>
                                    </div>
                                    <div class="entry value"><span>${row.quantity}</span></div>
                                    <div class="value-plus">
                                        <a class="cart_quantity_up"> + </a>
                                    </div>
                                </div>
                            </td>
                            <td class="cart_total">
                                <div class="row">
                                    <div class="col-md-8">
                                        <p class="cart_total_price totalPrice">${row.price * row.quantity}</p>
                                    </div>
                                    <div class="col-md-4">
                                         <span class="cart_total_price">&#36;</span>
                                    </div>
                                </div>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete"><i class="fa fa-times close1"></i></a>
                            </td>
                        </tr>`

            $('#myTable tr:last').after(insertedRow);
        })
    }

    $(document).on('click', '.value-plus', function () {
        var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) + 1;
        divUpd.text(newVal);
        var totNode = $(this).parent().parent().parent().find('.cart_total .row .col-md-8 p');
        var priceNode = $(this).parent().parent().parent().find('.cart_price  p');
        calcPrice(newVal, totNode, priceNode);


    });


    $(document).on('click', '.check_out', function () {
        var json = JSON.stringify(get_AllProducts());
        console.log("==========" + json);
        $.ajax({
            type: "POST",
            url: "orders",
            dataType: "JSON",
            data: {products: json},
            statusCode: {
                201: function (data) {
                    console.log(data);
                    onSuccess(data);
                },
                460: function () {
                    console.log("error")
                    onError(data);
                },
                500: function () {
                    alert("leh ya rb m 5k2tny4 m3za");
                },
                302: function (data) {
                    setRedirect(data);
                }

            }
        })

    });
    $(document).on('click', '.value-minus', function () {
        var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) - 1;
        if (newVal >= 1) {
            divUpd.text(newVal);
            var totNode = $(this).parent().parent().parent().find('.cart_total .row .col-md-8 p');
            var priceNode = $(this).parent().parent().parent().find('.cart_price  p');
            calcPrice(newVal, totNode, priceNode);
        }

    });
    $(document).on('click', '.close1', function () {
        $(this).parents("tr").remove();
        calcTotal();
    });

    function calcPrice(newVal, totNode, priceNode) {
        var price = parseFloat(priceNode.text());
        var newPriceTotal = newVal * price;
        totNode.text(newPriceTotal);
        calcTotal();
    }

    function updateCartProducts() {
        var allIds = $(".productId");
        var qty = $(".value");
        var cart_price = $(".cart_price");
        let allProducts = new Array;
        var totalPrice = $(".totalPrice");

        for (var i = 0; i < allIds.length; i++) {
            console.log($(allIds[i]).text());
            console.log($(qty[i]).text());
            var product = {
                productId: $(allIds[i]).text(), productName: "", description: "",
                manufacturingName: "", manufacturingDate: "",
                expirationDate: ""
                , quantity: $(qty[i]).text(),
                categories: [],
                price: $(cart_price[i]).text().trim(),
                primaryImage: "",
                images: []
            }
            allProducts.push(product);
            console.log(product);
        }
        localStorage.setItem('products', JSON.stringify(allProducts));
    }

    function onSuccess(data) {
        // var json = JSON.parse(data);
        $("#do_action").hide();
        $("#response").show();
        $("#response_message").val(data.message);
    }

    function setRedirect(data) {
        // var json = JSON.parse(data);
        $("#do_action").hide();
        $("#response").show();
        $("#response_message").val(data.message);
        // similar behavior as clicking on a link
        // window.location.href = "http://stackoverflow.com";


    }

    function onError(data) {
        // var json = JSON.parse(data);
        $("#do_action").hide();
        $("#response").show();
        $("#response_message").val(data.message);
    }
});