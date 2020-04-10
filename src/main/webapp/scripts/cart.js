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
            type: "GET",
            url: "products",
            dataType: "JSON",
            data: {products: json},
            statusCode: {
                200: function (data) {
                    console.log(data);
                    // receiveMessage(data);
                },
                404: function () {
                    console.log("error")
                }

            }
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