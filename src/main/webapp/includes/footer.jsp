<footer class="page-footer font-small unique-color-dark" style="background-color: #222;">

    <div class="bg-dark">
        <div class="container bg-dark">

            <div class="row py-4 d-flex align-items-center">

                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h6 class="mb-0">Get connected with us on social networks!</h6>
                </div>

                <div class="col-md-6 col-lg-7 text-center text-md-right">
                    <a href="${applicationScope.storeInstance.getFaceBook()}" class="fb-ic"><i
                            class="fab fa-facebook-f white-text mr-4"></i></a>
                    <a href="${applicationScope.storeInstance.getTwitter()}" class="tw-ic"><i
                            class="fab fa-twitter white-text mr-4"></i></a>
                    <a href="${applicationScope.storeInstance.getYoutube()}" class="gplus-ic"><i
                            class="fab fa-youtube white-text mr-4"></i></a>
                    <a href="${applicationScope.storeInstance.getLinkedin()}" class="li-ic"><i
                            class="fab fa-linkedin-in white-text mr-4"></i></a>
                    <a href="${applicationScope.storeInstance.getInstagram()}" class="ins-ic"><i
                            class="fab fa-instagram white-text"></i></a>
                </div>

            </div>

        </div>
    </div>

    <div class="container text-center text-md-left mt-5">
        <div class="row mt-3">

            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                <h6 class="text-uppercase font-weight-bold">${applicationScope.storeInstance.getStoreName()}</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>${applicationScope.storeInstance.getDescription()}</p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="text-uppercase font-weight-bold">${applicationScope.storeInstance.linksTitle}</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p><a href="${applicationScope.storeInstance.linkAddress1}">${applicationScope.storeInstance.link1}</a>
                </p>
                <p><a href="${applicationScope.storeInstance.linkAddress2}">${applicationScope.storeInstance.link2}</a>
                </p>
                <p><a href="${applicationScope.storeInstance.linkAddress3}">${applicationScope.storeInstance.link3}</a>
                </p>
                <p><a href="${applicationScope.storeInstance.linkAddress4}">${applicationScope.storeInstance.link4}</a>
                </p>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="text-uppercase font-weight-bold">Navigation</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p><a href="/iti-store/home"> Store Home</a></p>
                <p><a href="/iti-store/products"> Our Products</a></p>
                <p><a href="/iti-store/about"> About Store</a></p>
                <p><a href="/iti-store/feedback"> Feedback</a></p>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <h6 class="text-uppercase font-weight-bold">Contact</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> ${applicationScope.storeInstance.getAddress().getCountry()}, ${applicationScope.storeInstance.getAddress().getCity()}
                </p>
                <p><i class="fas fa-envelope mr-3"></i> ${applicationScope.storeInstance.getEmail()}</p>
                <p><i class="fas fa-phone mr-3"></i> ${applicationScope.storeInstance.getPhoneNumber()}</p>
                <p><i class="fas fa-print mr-3"></i> ${applicationScope.storeInstance.getFaxNumber()}</p>
            </div>

        </div>
    </div>

    <div class="text-center text-muted py-1" style="background-color: #333;">
        Made with <span style="color: lightblue;"> &#9825; </span> JETS Intake 40
    </div>

</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- script js -->
<script src="scripts/app.js"></script>

<%--<script src="scripts/cart.js"></script>--%>

