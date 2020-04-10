<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Login</title>
	<%@include file="includes/head.jsp" %>
</head>

<body>
	<header>
		<%@include file="includes/header.jsp" %>
	</header>

	<div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">ITI Store</h1>
            <p class="lead">This is where you can buy ITI souvniers to remember this place and the AMAZING people you've met.</p>
        </div>
    </div>
	
	<br>

	<div class="container">
		<form>
			<div class="form-group">
				<label for="emailAddress">Email address</label>
				<input type="email" class="form-control" id="emailAddress" aria-describedby="emailHelp">
				<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
					else.</small>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label>
				<input type="password" class="form-control" id="userPassword">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="rememberMe">
				<label class="form-check-label" for="rememberMe">Remember me</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>

	<br>

	<%@include file="includes/footer.jsp" %>
</body>

</html>