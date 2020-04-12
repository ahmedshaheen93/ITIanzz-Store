$(document).ready(function () {
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

    $(".addToCart").on('click', function (event) {
        console.log("in the method")
        var productId = event.target.id;
        console.log(productId)
        var product = {
            productId: productId, productName: "", description: "",
            manufacturingName: "", manufacturingDate: "",
            expirationDate: ""
            , quantity: 1,
            categories: [],
            price: 0.0,
            primaryImage: "",
            images: []
        }
        var allProducts = get_AllProducts();
        console.log(allProducts)
        let found = false;
        allProducts.forEach(i => {
            if (i.productId === product.productId) {
                found = true;
            }
        });
        if (!found) {
            allProducts.push(product);
        }
        localStorage.setItem('products', JSON.stringify(allProducts));

    });
});