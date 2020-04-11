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
                },
                404: function () {
                    console.log("error")
                },
                500: function () {
                   alert("leh ya rb m 5k2tny4 m3za");
                }

            }
        })

    }

    /*
    *
    *                       <tr class="rem1">
                            <td class="cart_product">
                                <a href=""><img src="images/cart/one.png" alt=""></a>
                            </td>
                            <td class="cart_description">
                                <h4><a href="">Colorblock Scuba</a></h4>
                                <p>Web ID: 1089772</p>
                            </td>
                            <td class="cart_price">
                                <p>$59</p>
                            </td>
                            <td class="cart_quantity">
                                <div class="cart_quantity_button">
                                    <div class="value-minus">
                                        <a class="cart_quantity_down"> - </a>
                                    </div>
                                    <div class="entry value"><span>1</span></div>
                                    <div class="value-plus">
                                        <a class="cart_quantity_up"> + </a>
                                    </div>
                                </div>
                            </td>
                            <td class="cart_total">
                                <p class="cart_total_price">$59</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete"><i class="fa fa-times close1"></i></a>
                            </td>
                        </tr>

    *
    * *///
    var tableRef = document.getElementById('myTable').getElementsByTagName('tbody')[0];
    function displayData(data) {
        data.forEach(row=>{
            var insertedRow = "<tr class=\"rem1\">\n" +
                "                            <td class=\"cart_product\">\n" +
                "                                <a href=\"\"><img src=\"images/cart/one.png\" alt=\"\"></a>\n" +
                "                            </td>\n" +
                "                            <td class=\"cart_description\">\n" +
                "                                <h4><a href=\"\">"+row.productName+"</a></h4>\n" +
                "                                <p>Web ID: 1089772</p>\n" +
                "                            </td>\n" +
                "                            <td class=\"cart_price\">\n" +
                "                                <p>$"+row.price+"</p>\n" +
                "                            </td>\n" +
                "                            <td class=\"cart_quantity\">\n" +
                "                                <div class=\"cart_quantity_button\">\n" +
                "                                    <div class=\"value-minus\">\n" +
                "                                        <a class=\"cart_quantity_down\"> - </a>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"entry value\"><span>1</span></div>\n" +
                "                                    <div class=\"value-plus\">\n" +
                "                                        <a class=\"cart_quantity_up\"> + </a>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </td>\n" +
                "                            <td class=\"cart_total\">\n" +
                "                                <p class=\"cart_total_price\">$59</p>\n" +
                "                            </td>\n" +
                "                            <td class=\"cart_delete\">\n" +
                "                                <a class=\"cart_quantity_delete\"><i class=\"fa fa-times close1\"></i></a>\n" +
                "                            </td>\n" +
                "                        </tr>\n";

            $('#myTable tr:last').after(insertedRow);
        })
    }

    $('.value-plus').on('click', function () {
        var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) + 1;
        divUpd.text(newVal);
    });

    $('.value-minus').on('click', function () {
        var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) - 1;
        if (newVal >= 1) divUpd.text(newVal);
    });
    $('.close1').on('click', function () {
        $('.rem1').fadeOut('slow', function () {
            $('.rem1').remove();
        });
    });
});