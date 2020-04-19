<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>profile</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
        <br>
    </header>

    <div class="container">
        <div class="row">
            <div class="col-md-8">

                <div class="card">
                    <div class="card-header">
                        <h5 class="title">Profile Details</h5>
                    </div>
                    <div class="card-body">
                        <form action="/iti-store/update-profile" method="post">

                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input name="firstName" type="text" class="form-control"
                                            placeholder="First Name" value="${sessionScope.user.firstName}">
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input name="lastName" type="text" class="form-control" placeholder="Last Name"
                                            value="${sessionScope.user.lastName}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>Phone Number</label>
                                        <input name="phone" type="tel" class="form-control" placeholder="Phone Number"
                                            value="${sessionScope.user.phone}">
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input name="email" type="email" class="form-control"
                                            placeholder="Email Address" value="${sessionScope.user.email}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input name="password" type="password" class="form-control"
                                            placeholder="Password" value="${sessionScope.user.password}">
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>Confirm Password</label>
                                        <input name="confirmPassword" type="password" class="form-control"
                                            placeholder="Confirm Password" value="${sessionScope.user.password}">
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Country</label>
                                    <input name="country" type="text" class="form-control" placeholder="Country"
                                        value="${sessionScope.user.address.country}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Birth Date</label>
                                    <input name="birthDate" type="date" class="form-control" placeholder="Birth Date"
                                        value="${sessionScope.user.birthDate}">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>State</label>
                                    <input name="state" type="text" class="form-control" placeholder="State"
                                        value="${sessionScope.user.address.state}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>City</label>
                                    <input name="city" type="text" class="form-control" placeholder="City"
                                        value="${sessionScope.user.address.city}">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Street</label>
                                    <input name="street" type="text" class="form-control" placeholder="Street"
                                        value="${sessionScope.user.address.street}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Postal Code</label>
                                    <input name="zipCode" type="text" class="form-control" placeholder="ZIP Code"
                                        value="${sessionScope.user.address.zipCode}">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label>Profile Image</label>
                                    <input name="image" type="file" class="form-control" placeholder="Choose a new profile image...">
                                </div>
                                <br>
                            </div>

                            <br>

                            <!-- How Could you do that !!! -->
                            <div class="d-flex justify-content-between">
                                <div>
                                    <h6> </h6>
                                </div>
                                <div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <input type="hidden" name="id" value="${sessionScope.user.userId}">
                                            <input type="submit" class="btn btn-primary text-white"
                                                value="   Save Updates   ">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
            <div class="col-md-4">

                <div class="card">
                    <div class="card-header">
                        <div class="d-flex justify-content-between">
                            <div>
                                <h5 class="title">${sessionScope.user.firstName} ${sessionScope.user.lastName}</h5>
                            </div>
                            <div>
                                <p class="card-text"><small
                                        class="text-muted">${sessionScope.user.role.toString().replace("_ROLE",
                                        "")}</small></p>

                            </div>
                        </div>

                    </div>

                    <c:choose>
                        <c:when test="${sessionScope.user.userImage != null}">
                            <img src="${sessionScope.user.userImage.imagePath}" class="card-img-top img-fluid"
                                alt="Profile Image">
                        </c:when>
                        <c:otherwise>
                            <img src="images/user/avatar.jpg" class="card-img-top img-fluid"
                                alt="Default Profile Image">
                        </c:otherwise>
                    </c:choose>

                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <div class="d-flex justify-content-between">
                                    <div>
                                        Orders
                                    </div>
                                    <div>
                                        ${sessionScope.user.orders.size()}
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="d-flex justify-content-between">
                                    <div>
                                        Balance
                                    </div>
                                    <div>
                                        ${sessionScope.user.balance}
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <br>

                <div class="card">
                    <div class="card-header">
                        <h5 class="title">Navigation</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><a href="/iti-store/view-profile" class="card-link">View
                                    Profile Details</a></li>
                            <li class="list-group-item"><a href="/iti-store/cart" class="card-link">View Current
                                    Cart</a></li>
                            <li class="list-group-item" data-toggle="modal" data-target="#requestBalanceModel"><a
                                    href="#" class="card-link">Add Balance</a></li>
                        </ul>
                    </div>
                </div>

                <br>

            </div>
        </div>
    </div>

    <%@include file="includes/footer.jsp" %>
</body>

</html>