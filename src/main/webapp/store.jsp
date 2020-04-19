<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Store Information</title>
    <%@include file="includes/head.jsp" %>
</head>

<body>
    <header>
        <%@include file="includes/header.jsp" %>
    </header>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Store Details</h1>
            <p class="lead">Customise the store to suit your needs, and make it truly yours.</p>
        </div>
    </div>

    <br>

    <div class="container">

        <form method="POST">
            <h2>Basic Information</h2>

            <div class="form-group">
                <label for="formGroupName">Store name</label>
                <input name="name" type="text" class="form-control" id="formGroupName"
                    value="${applicationScope.storeInstance.getStoreName()}">
            </div>
            <div class="form-group">
                <label for="formGroupDesciption">Store description</label>
                <input name="description" type="text" class="form-control" id="formGroupDesciption"
                    value="${applicationScope.storeInstance.getDescription()}">
            </div>
            <div class="form-group">
                <label for="formGroupEmail">Store email address</label>
                <input name="email" type="email" class="form-control" id="formGroupEmail"
                    value="${applicationScope.storeInstance.getEmail()}">
            </div>
            <div class="form-group">
                <label for="formGroupPhone">Store phone number</label>
                <input name="phone" type="text" class="form-control" id="formGroupPhone"
                    value="${applicationScope.storeInstance.getPhoneNumber()}">
            </div>
            <div class="form-group">
                <label for="formGroupFax">Store fax number</label>
                <input name="fax" type="text" class="form-control" id="formGroupFax"
                    value="${applicationScope.storeInstance.getFaxNumber()}">
            </div>

            <hr>
            <br>
            <br>
            <h2>Address Details</h2>

            <div class="form-group">
                <label for="formGroupCountry">Store country</label>
                <input name="country" type="text" class="form-control" id="formGroupCountry"
                    value="${applicationScope.storeInstance.getAddress().getCountry()}">
            </div>
            <div class="form-group">
                <label for="formGroupState">Store state</label>
                <input name="state" type="text" class="form-control" id="formGroupState"
                    value="${applicationScope.storeInstance.getAddress().getState()}">
            </div>
            <div class="form-group">
                <label for="formGroupCity">Store city</label>
                <input name="city" type="text" class="form-control" id="formGroupCity"
                    value="${applicationScope.storeInstance.getAddress().getCity()}">
            </div>
            <div class="form-group">
                <label for="formGroupStreet">Store street</label>
                <input name="street" type="text" class="form-control" id="formGroupStreet"
                    value="${applicationScope.storeInstance.getAddress().getStreet()}">
            </div>
            <div class="form-group">
                <label for="formGroupZipcode">Store zip code</label>
                <input name="zipcode" type="text" class="form-control" id="formGroupZipcode"
                    value="${applicationScope.storeInstance.getAddress().getZipCode()}">
            </div>

            <hr>
            <br>
            <br>
            <h2>Social Media Accounts</h2>

            <div class="form-group">
                <label for="formGroupFacebook">Store facebook account</label>
                <input name="facebook" type="text" class="form-control" id="formGroupFacebook"
                    value="${applicationScope.storeInstance.getFaceBook()}">
            </div>
            <div class="form-group">
                <label for="formGroupTwitter">Store twitter account</label>
                <input name="twitter" type="text" class="form-control" id="formGroupTwitter"
                    value="${applicationScope.storeInstance.getTwitter()}">
            </div>
            <div class="form-group">
                <label for="formGroupYoutube">Store youtube account</label>
                <input name="youtube" type="text" class="form-control" id="formGroupYoutube"
                    value="${applicationScope.storeInstance.getYoutube()}">
            </div>
            <div class="form-group">
                <label for="formGroupLinkedin">Store linkedin account</label>
                <input name="linkedin" type="text" class="form-control" id="formGroupLinkedin"
                    value="${applicationScope.storeInstance.getLinkedin()}">
            </div>
            <div class="form-group">
                <label for="formGroupInstagram">Store instagram account</label>
                <input name="instagram" type="text" class="form-control" id="formGroupInstagram"
                    value="${applicationScope.storeInstance.getInstagram()}">
            </div>
            <hr>
            <br>
            <br>
            <h2>Slider Titles</h2>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupFirstTitle">First title</label>
                    <input name="sliderTitle1" type="text" class="form-control" id="formGroupFirstTitle"
                        value="${applicationScope.storeInstance.sliderTitle1}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupFirstSubTitle">First sub title</label>
                    <input name="sliderSubTitle1" type="text" class="form-control" id="formGroupFirstSubTitle"
                        value="${applicationScope.storeInstance.sliderSubTitle1}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupSecondTitle">Second title</label>
                    <input name="sliderTitle2" type="text" class="form-control" id="formGroupSecondTitle"
                        value="${applicationScope.storeInstance.sliderTitle2}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupSecondSubTitle">Second sub title</label>
                    <input name="sliderSubTitle2" type="text" class="form-control" id="formGroupSecondSubTitle"
                        value="${applicationScope.storeInstance.sliderSubTitle2}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupThirdTitle">Third title</label>
                    <input name="sliderTitle3" type="text" class="form-control" id="formGroupThirdTitle"
                        value="${applicationScope.storeInstance.sliderTitle3}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupThirdSubTitle">Third sub title</label>
                    <input name="sliderSubTitle3" type="text" class="form-control" id="formGroupThirdSubTitle"
                        value="${applicationScope.storeInstance.sliderSubTitle3}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupFourthTitle">Fourth title</label>
                    <input name="sliderTitle4" type="text" class="form-control" id="formGroupFourthTitle"
                        value="${applicationScope.storeInstance.sliderTitle4}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupFourthSubTitle">Fourth sub title</label>
                    <input name="sliderSubTitle4" type="text" class="form-control" id="formGroupFourthSubTitle"
                        value="${applicationScope.storeInstance.sliderSubTitle4}">
                </div>
            </div>


            <hr>
            <br>
            <br>
            <h2>Footer Links</h2>

            <div class="form-group">
                <label for="formGroupFooterLinks">Footer links title</label>
                <input name="linksTitle" type="text" class="form-control" id="formGroupFooterLinks"
                    value="${applicationScope.storeInstance.linksTitle}">
            </div>



            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupFirstLink">First link</label>
                    <input name="link1" type="text" class="form-control" id="formGroupFirstLink"
                        value="${applicationScope.storeInstance.link1}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupFirstLinkAddress">First link Address</label>
                    <input name="linkAddress1" type="text" class="form-control" id="formGroupFirstLinkAddress"
                        value="${applicationScope.storeInstance.linkAddress1}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupSecondLink">Second link</label>
                    <input name="link2" type="text" class="form-control" id="formGroupSecondLink"
                        value="${applicationScope.storeInstance.link2}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupSecondLinkAddress">Second link Address</label>
                    <input name="linkAddress2" type="text" class="form-control" id="formGroupSecondLinkAddress"
                        value="${applicationScope.storeInstance.linkAddress2}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupThirdLink">Third link</label>
                    <input name="link3" type="text" class="form-control" id="formGroupThirdLink"
                        value="${applicationScope.storeInstance.link3}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupThirdLinkAddress">Third link Address</label>
                    <input name="linkAddress3" type="text" class="form-control" id="formGroupThirdLinkAddress"
                        value="${applicationScope.storeInstance.linkAddress3}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="formGroupFourthLink">Fourth link</label>
                    <input name="link4" type="text" class="form-control" id="formGroupFourthLink"
                        value="${applicationScope.storeInstance.link4}">
                </div>
                <div class="form-group col-md-6">
                    <label for="formGroupFourthLinkAddress">Fourth link Address</label>
                    <input name="linkAddress4" type="text" class="form-control" id="formGroupFourthLinkAddress"
                        value="${applicationScope.storeInstance.linkAddress4}">
                </div>
            </div>

            <hr>
            <br>
            <button class="btn btn-primary" type="submit">Update Store Information</button>
        </form>

        <br>
        <br>

    </div>

    <%@include file="includes/footer.jsp" %>

</body>

</html>