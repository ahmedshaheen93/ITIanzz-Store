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

    var addToCart = function(event){

        var productId = event.target.id;
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
    };

    $(".addToCart").on('click',(event) => addToCart(event));
});