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
                                        <a href="#"
                                           class="btn btn-sm btn-primary <c:if test="${user.role == Role.ADMIN_ROLE}">
                                                          btn-dark</c:if>">
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

<%@include file="includes/footer.jsp" %>
</body>
</html>
