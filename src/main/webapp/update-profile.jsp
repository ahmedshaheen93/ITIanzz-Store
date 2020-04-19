<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>profile</title>
    <%@include file="includes/head.jsp" %>
    <link rel="stylesheet" href="styles/profile-style.css">
    <link href="styles/now-ui-dashboard.css?v=1.5.0" rel="stylesheet">
    <link href="styles/demo.css" rel="stylesheet">
</head>

<body>
<header>
    <%@include file="includes/header.jsp" %>
</header>
<div class="wrapper">
    <div class="content" style="width: 80%; height: 60%; margin-left: 110px">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h5 class="title">Edit Profile</h5>
                    </div>
                    <div class="card-body">
                        <form action="/iti-store/update-profile" method="post">
                            <div class="row">
                                <div class="col-md-5 pr-1">
                                    <div class="form-group">
                                        <label>Phone Number</label>
                                        <input type="tel" name="phone" class="form-control" placeholder="phone"
                                               value="${sessionScope.user.phone}">
                                    </div>
                                </div>
                                <div class="col-md-7 pl-1">
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" name="email" class="form-control" placeholder="Email"
                                               value="${sessionScope.user.email}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" name="firstName" class="form-control" placeholder="Company"
                                               value="${sessionScope.user.firstName}">
                                    </div>
                                </div>
                                <div class="col-md-6 pl-1">
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" name="lastName" class="form-control" placeholder="Last Name"
                                               value="${sessionScope.user.lastName}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" name="address" class="form-control"
                                               placeholder="Home Address"
                                               value="${sessionScope.user.address}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4 pr-1">
                                    <div class="form-group">
                                        <label>City</label>
                                        <input type="text" name="city" class="form-control" placeholder="City"
                                               value="${sessionScope.user.address.city}">
                                    </div>
                                </div>
                                <div class="col-md-4 px-1">
                                    <div class="form-group">
                                        <label>Country</label>
                                        <input type="text" name="country" class="form-control" placeholder="Country"
                                               value="${sessionScope.user.address.country}">
                                    </div>
                                </div>
                                <div class="col-md-4 pl-1">
                                    <div class="form-group">
                                        <label>Postal Code</label>
                                        <input type="text" name="zipCode" class="form-control" placeholder="ZIP Code"
                                               value="${sessionScope.user.address.zipCode}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-11 pr-1">
                                    <div class="form-group">
                                        <input type="hidden" name="id" value="${sessionScope.user.userId}">
                                        <input type="submit" style="border-radius: 15px; float: right"
                                               class="label theme-bg3 btn text-white f-12" value="update">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card card-user">
                    <div class="image">
                        <img src="images/user/bg5.jpg" alt="...">
                    </div>
                    <div class="card-body">
                        <div class="author">
                            <img class="avatar border-gray" src="${sessionScope.user.userImage.imagePath}" alt="...">
                            <h5 class="title">${sessionScope.user.firstName} ${sessionScope.user.lastName}</h5>
                            <p class="description">
                                ${sessionScope.user.email}
                            </p>
                            <div class="button-container">
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-facebook-f"></i>
                                </button>
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-twitter"></i>
                                </button>
                                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                                    <i class="fab fa-google-plus-g"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>