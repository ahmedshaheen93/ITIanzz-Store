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
        var productId = event.target.id;
        // private Long productId;
        // private String productName;
        // private String description;
        // private String manufacturingName;
        // private LocalDate manufacturingDate;
        // private LocalDate expirationDate;
        // private int quantity;
        // private Set<Category> categories = new HashSet<>(0);
        // private Double price;
        // private String primaryImage;
        // private Set<String> images = new HashSet<>(0);

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

    });
});