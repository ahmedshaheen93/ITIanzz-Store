<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>All users on the system</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <link rel="stylesheet" href="styles/all.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <%@include file="includes/head.jsp" %>
</head>
<body>
<header>
    <%@include file="includes/header.jsp" %>
    <br>
</header>

<div class="container">
    <form class="form-inline ml-3">
        <div class="input-group input-group-sm">
            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
            <div class="input-group-append">
                <button class="btn btn-navbar" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </div>
    </form>
    <br>
    <div class="card card-solid">
        <div class="card-body pb-0">
            <div class="row d-flex align-items-stretch">
                <c:if test="${!empty requestScope.users}">
                    <c:forEach var="user" items="${requestScope.users}">
                        <div class="col-12 col-sm-6 col-md-4 d-flex align-items-stretch">
                            <div class="card bg-light">
                                <div class="card-header text-muted border-bottom-0">

                                    <h2 class="lead"><b><c:if test="${user.role == Role.ADMIN_ROLE}">
                                        <i class="fas fa-star"></i>
                                    </c:if> ${user.firstName} ${user.lastName}</b></h2>

                                </div>
                                <div class="card-body pt-0">
                                    <div class="row">
                                        <div class="col-7">
                                            <p class="text-muted text-sm"><b>Mail:</b> ${user.email}</p>
                                            <ul class="ml-4 mb-0 fa-ul text-muted">
                                                <li class="small"><span class="fa-li"><i
                                                        class="fas fa-lg fa-building"></i></span>
                                                    <b>Address:</b> ${user.address.street} ,
                                                        ${user.address.city}
                                                        ${user.address.state}
                                                    , ${user.address.zipCode}, ${user.address.country}
                                                </li>
                                                <li class="small" type="tel"><span class="fa-li"><i
                                                        class="fas fa-lg fa-phone"></i></span>
                                                    <b>Phone:</b> ${user.phone}
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-5 text-center">
                                            <c:if test="${!empty user.userImage}">
                                                <img src="/iti-store/images?imageId=${user.userImage.imageId}" alt=""
                                                     class="img-circle img-fluid">
                                            </c:if>
                                            <c:if test="${empty user.userImage}">
                                                <img src="images/user/avatar.jpg" alt=""
                                                     class="img-circle img-fluid">
                                            </c:if>

                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer <c:if test="${user.role == Role.ADMIN_ROLE}">
                                                          bg-dark</c:if>">
                                    <div class=" text-right">
                                        <c:if test="${user.role != Role.ADMIN_ROLE}">
                                            <a class="btn btn-sm btn-dark text-white"
                                               href="make-as-admin?id=${user.userId}&admin=true">
                                                <i class="fas fa-star"></i> Set As Admin
                                            </a>
                                        </c:if>
                                        <c:if test="${user.role == Role.ADMIN_ROLE}">
                                            <a class="btn btn-sm btn-dark text-white"
                                               href="make-as-admin?id=${user.userId}&admin=false">
                                                <i class="fas fa-user"></i> Set As Customer
                                            </a>
                                        </c:if>
                                        <a id="${user.userId}"
                                           class="btn btn-sm btn-primary text-white view-profile <c:if test="${user.role == Role.ADMIN_ROLE}">
                                                          btn-dark</c:if>" data-toggle="modal" data-target="#modal-lg">
                                            <i class="fas fa-user"></i> View Profile
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

            </div>
        </div>
    </div>
</div>
<br>
<div class="modal fade" id="modal-lg">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Large Modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="card">
                    <div class="card-header">
                        <h5 class="title">Profile Details</h5>
                    </div>
                    <div class="row">
                        <div class="col-md-4">

                            <div class="card">
                                <div class="card-header">
                                    <div class="d-flex justify-content-between">
                                        <div>
                                            <h5 class="title" id="title"></h5>
                                        </div>
                                        <div>
                                            <p class="card-text"><small
                                                    class="text-muted" id="role"></small></p>

                                        </div>
                                    </div>

                                </div>

                                <img src="" id="profileImage"
                                     class="card-img-top img-fluid"
                                     alt="Profile Image">

                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">
                                            <div class="d-flex justify-content-between">
                                                <div>
                                                    Orders
                                                </div>
                                                <div>
                                                    <p id="orders"></p>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="list-group-item">
                                            <div class="d-flex justify-content-between">
                                                <div>
                                                    Balance
                                                </div>
                                                <div>
                                                    <p id="balance"></p>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-8">
                            <div class="card-body">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>First Name</label>
                                        <input type="text" class="form-control" placeholder="First Name"
                                               id="firstName" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control" placeholder="Last Name"
                                               id="lastName" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Phone Number</label>
                                        <input type="tel" class="form-control" placeholder="Phone Number"
                                               id="phone" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Email address</label>
                                        <input type="email" class="form-control" placeholder="Email Address"
                                               id="email" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Country</label>
                                        <input type="text" class="form-control" placeholder="Country"
                                               id="country" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Birth Date</label>
                                        <input type="text" class="form-control" placeholder="Birth Date"
                                               id="birthDate" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>State</label>
                                        <input type="text" class="form-control" placeholder="State"
                                               id="state" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>City</label>
                                        <input type="text" class="form-control" placeholder="City"
                                               id="city" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Street</label>
                                        <input type="text" class="form-control" placeholder="Street"
                                               id="street" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Postal Code</label>
                                        <input type="text" class="form-control" placeholder="ZIP Code"
                                               id="zipCode" disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@include file="includes/footer.jsp" %>
<script src="scripts/users.js"></script>
</body>
</html>
