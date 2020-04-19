<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Profile</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
        <br>
    </header>
    <div class="wrapper">
        <div class="content" style="width: 80%; height: 60%; margin-left: 110px">
            <div class="row">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="title">Profile</h5>
                            <i type="button" class="btn btn-primary submit eatured-search-icon" data-toggle="modal"
                                data-target="#requestBalanceModel">Request Balance</i>

                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input type="tel" class="form-control" placeholder="phone"
                                                value="${sessionScope.user.phone}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-md-7 pl-1">
                                        <div class="form-group">
                                            <label>Email address</label>
                                            <input type="email" class="form-control" placeholder="Email"
                                                value="${sessionScope.user.email}" disabled>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input type="text" class="form-control" placeholder="Company"
                                                value="${sessionScope.user.firstName}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-md-6 pl-1">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input type="text" class="form-control" placeholder="Last Name"
                                                value="${sessionScope.user.lastName}" disabled>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control" placeholder="Home Address"
                                                value="${sessionScope.user.address}" disabled>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 pr-1">
                                        <div class="form-group">
                                            <label>City</label>
                                            <input type="text" class="form-control" placeholder="City"
                                                value="${sessionScope.user.address.city}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-md-4 px-1">
                                        <div class="form-group">
                                            <label>Country</label>
                                            <input type="text" class="form-control" placeholder="Country"
                                                value="${sessionScope.user.address.country}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-md-4 pl-1">
                                        <div class="form-group">
                                            <label>Postal Code</label>
                                            <input type="text" class="form-control" placeholder="ZIP Code"
                                                value="${sessionScope.user.address.zipCode}" disabled>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">

                    <div class="card" style="width: 18rem;">
                        <!-- src="${sessionScope.user.userImage.imagePath}" -->
                        <img src="images/user/bg5.jpg" class="card-img-top" alt="profile image">
                        <div class="card-body">
                            <h5 class="card-title">${sessionScope.user.firstName} ${sessionScope.user.lastName}</h5>
                            <p class="card-text">${sessionScope.user.email}</p>
                        </div>
                        <div class="card-body">
                            <a href="#" class="card-link">Update Profile Details</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="requestBalanceModel" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!-- modal header -->
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize">Request For Balance</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--end of  modal header -->
                <!-- modal body -->
                <div class="modal-body">
                    <div class="row">
                        <label for="requestBalance" class="col control-label">Amount of Money</label>
                        <div class="col">
                            <input aria-invalid="amount" type="number" name="requestBalance" class="form-control"
                                min="1" id="requestBalance">
                        </div>

                    </div>
                </div>
                <!-- end modal body -->
                <div class="modal-footer">
                    <button class="btn btn-danger my-2 mx-2  addBalance" data-dismiss="modal">Request Balance</button>
                    <%-- <button type="button" class="btn btn-danger " data-dismiss="modal">close modal</button>--%>
                </div>
            </div>
        </div>
    </div>
    
    <br>

    <%@include file="includes/footer.jsp" %>
    <script src="scripts/requestBalance.js"></script>

</body>

</html>