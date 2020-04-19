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
                            <h5 class="title">Profile Details</h5>
                        </div>
                        <div class="card-body">
                            <form>

                                <div class="row">
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input type="text" class="form-control" placeholder="First Name"
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
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>Phone Number</label>
                                            <input type="tel" class="form-control" placeholder="Phone Number"
                                                value="${sessionScope.user.phone}" disabled>
                                        </div>
                                    </div>
                                    <div class="col-md-6 pl-1">
                                        <div class="form-group">
                                            <label>Email address</label>
                                            <input type="email" class="form-control" placeholder="Email Address"
                                                value="${sessionScope.user.email}" disabled>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Country</label>
                                        <input type="text" class="form-control" placeholder="Country"
                                            value="${sessionScope.user.address.country}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Birth Date</label>
                                        <input type="text" class="form-control" placeholder="Birth Date"
                                            value="${sessionScope.user.birthDate}" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>State</label>
                                        <input type="text" class="form-control" placeholder="State"
                                            value="${sessionScope.user.address.state}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>City</label>
                                        <input type="text" class="form-control" placeholder="City"
                                            value="${sessionScope.user.address.city}" disabled>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Street</label>
                                        <input type="text" class="form-control" placeholder="Street"
                                            value="${sessionScope.user.address.street}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Postal Code</label>
                                        <input type="text" class="form-control" placeholder="ZIP Code"
                                            value="${sessionScope.user.address.zipCode}" disabled>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                    
                    <br>

                    <div class="card">
                        <div class="card-header">
                            <h5 class="title">Purchase Orders</h5>
                            <!-- <i type="button" class="btn btn-primary submit eatured-search-icon" data-toggle="modal"
                                data-target="#requestBalanceModel">Request Balance</i> -->
                        </div>
                        <div class="card-body">

                        </div>
                    </div>

                </div>
                <div class="col-md-4">

                    <div class="card">
                        <div class="card-header text-center">
                            <h5 class="title">${sessionScope.user.firstName} ${sessionScope.user.lastName}</h5>
                        </div>
                        <!-- src="${sessionScope.user.userImage.imagePath}" -->
                        <img src="images/user/bg5.jpg" class="card-img-top img-fluid" alt="profile image">
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Orders: 44</li>
                                <li class="list-group-item">Products: 74</li>
                                <li class="list-group-item">Balance: 4500</li>
                            </ul>
                        </div>
                    </div>

                    <br>

                    <div class="card text-center">
                        <div class="card-header">
                            <h5 class="title">Update Profile</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><a href="/iti-store/update-profile" class="card-link">Edit Details</a></li>
                                <li class="list-group-item"data-toggle="modal" data-target="#requestBalanceModel"><a href="#" class="card-link">Request Balance</a></li>
                                <li class="list-group-item"><a href="#" class="card-link">Make Admin</a></li>
                            </ul>
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