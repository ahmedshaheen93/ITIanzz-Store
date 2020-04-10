<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Feedback</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <div class="container">

        <br>
        <h2>We would love to hear from you</h2>
        <p>Tell us what you think should be done more or what should be done less.</p>
        <br>

        <form method="POST">
            <div class="form-group">
                <label for="formGroupFullName">Full name</label>
                <input name="name" type="text" class="form-control" id="formGroupFullName" placeholder="e.g John Doe">
            </div>
            <div class="form-group">
                <label for="formGroupEmailAddress">Email address</label>
                <input name="email" type="email" class="form-control" id="formGroupEmailAddress" placeholder="e.g name@example.com">
            </div>
            <div class="form-group">
                <label for="formGroupFeedbackSubject">Feedback subject</label>
                <input name="subject" type="text" class="form-control" id="formGroupFeedbackSubject"
                    placeholder="e.g i would like to complain about ...">
            </div>
            <div class="form-group">
                <label for="formGroupFeedbackMessage">Feedback message</label>
                <textarea name="message" class="form-control" id="formGroupFeedbackMessage" rows="7"></textarea>
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Submit feedback</button>
        </form>

        <br>
        <br>

    </div>

    <%@include file="includes/footer.jsp" %>

</body>

</html>