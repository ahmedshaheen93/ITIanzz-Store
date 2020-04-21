<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Registration</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Registration</h1>
            <p class="lead">Join our wide and vibrant community of customers, and find the products you've been looking for.</p>
        </div>
    </div>

    <div class="container">
        <form id="registrationForm" method="POST">
            <c:if test="${!empty param['invalid']}">
                <h4 style="-webkit-text-fill-color: red">invalid inputs!!</h4>
            </c:if>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="userfirstname">First name</label>
                    <input name="firstname" type="text" class="form-control" id="userfirstname" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="userlastname">Last name</label>
                    <input name="lastname" type="text" class="form-control" id="userlastname" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="useremail">Email</label>
                    <input name="email" type="email" class="form-control" id="useremail" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="userpassword">Password</label>
                    <input name="password" type="password" class="form-control" id="userpassword" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="confirmPassword">Confirm Password</label>
                    <input name="confirmPassword" type="password" class="form-control"
                           id="confirmPassword" required onblur="validatePassword()">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="userphone">Phone number</label>
                    <input name="phone" type="text" class="form-control" id="userphone" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="userbirthdate">Birth date</label>
                <input name="birthdate" type="date" class="form-control" id="userbirthdate" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="usercountry">Country</label>
                    <input name="country" type="text" class="form-control" id="usercountry" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="userstate">State</label>
                    <input name="state" type="text" class="form-control" id="userstate" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="usercity">City</label>
                    <input name="city" type="text" class="form-control" id="usercity" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="userstreet">Street</label>
                    <input name="street" type="text" class="form-control" id="userstreet" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="userzipcode">Zip Code</label>
                    <input name="zipcode" type="text" class="form-control" id="userzipcode" required>
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>

    <br><br>

    <%@include file="includes/footer.jsp" %>
</body>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
    function validatePassword() {
        var validator = $("#registrationForm").validate({
            rules: {
                userpassword: "required",
                confirmPassword: {
                    equalTo: "#userpassword"
                }
            },
            messages: {
                userpassword: "enter password",
                confirmPassword: "confirm password must be as password"
            }
        });
        if (validator.form()) {
            alert('Success');
        }
    }
</script>
</html>