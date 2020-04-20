<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Logout</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Comeback</h1>
            <p class="lead">And don't miss out seeing all the new fabulous products you can buy.</p>
        </div>
    </div>

    <br>

    <div class="container">
        <h1>Goodbye</h1>
        <h4>Don't forget to share your <a href="/iti-store/feedback">Feedback</a> with us.</h4>
        <h4>We would love to hear from you.</h4>
        <br>
        <br>
    </div>

    <%@include file="includes/footer.jsp" %>

</body>

</html>