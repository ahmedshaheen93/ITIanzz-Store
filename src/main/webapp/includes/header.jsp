<nav class="navbar navbar-dark bg-dark navbar-expand-md container-fluid">

    <a class="navbar-brand">
        <img src="images/iti-logo.png" width="30" height="30" alt="ITI Store">
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item nav-active">
                <a class="nav-link" href="/iti-store/home">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/iti-store/products">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/iti-store/about">About</a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">


            <c:choose>
                <c:when test="${sessionScope.user.role == Role.ADMIN_ROLE}">
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/customers">Customers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/store">Store</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/view-profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/logout">Logout</a>
                    </li>
                </c:when>
                <c:when test="${sessionScope.user.role == Role.CUSTOMER_ROLE}">
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/view-profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/logout">Logout</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/registration">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/iti-store/login">Login</a>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>

</nav>
