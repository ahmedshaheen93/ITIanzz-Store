<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/22/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${applicationScope.storeInstance.storeName} - Forget Password</title>
    <%@include file="includes/head.jsp" %>
    <LINK href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://formden.com/static/cdn/bootstrap-iso.css" rel="stylesheet">
</head>
<body>
<header>
    <%@include file="includes/header.jsp" %>
</header>
<c:if test="${!empty requestScope.errorMessage}">
    <p>${requestScope.errorMessage}</p>
</c:if>
<div class="bootstrap-iso" style="padding-top: 35px">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3><i class="fa fa-lock fa-4x"></i></h3>
                            <h2 class="text-center">Forgot Password?</h2>
                            <p>You can reset your password here.</p>
                            <div class="panel-body">

                                <form id="register-form" action="/iti-store/forgetPassword" role="form" class="form"
                                      method="post">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-envelope"></span>
                                            </div>
                                            <input class="form-control" id="email" name="email" type="text" placeholder="email address"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block"
                                               value="Reset Password" type="submit">
                                    </div>

                                    <input type="hidden" class="hide" name="token" id="token" value="">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</body>
</html>
