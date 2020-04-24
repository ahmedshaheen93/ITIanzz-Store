<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>${applicationScope.storeInstance.storeName} - Feedback</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <div class="container">

        <br>

        <div class="card">
            <div class="card-header">
                <h5 class="title">Clients Feedbacks</h5>
            </div>
            <div class="card-body">

                <br>
                <div class="col-12">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <td>Name</td>
                                <td>Email</td>
                                <td>Subject</td>
                                <td>Message</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${applicationScope.feedbackService.getAllFeedbacks()}" var="feedback">
                                <tr>
                                    <td>${feedback.senderName}</td>
                                    <td>${feedback.senderEmail}</td>
                                    <td>${feedback.subject}</td>
                                    <td>${feedback.message}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

        <br>

    </div>

    <%@include file="includes/footer.jsp" %>

</body>

</html>