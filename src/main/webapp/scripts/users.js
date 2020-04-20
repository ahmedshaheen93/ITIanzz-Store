$(document).ready(function () {


    $(document).on('click', '.view-profile', function () {
        var id = this.id;

        $.ajax({
            url: "userInfo",
            type: "GET",
            dataType: "JSON",
            data: {"id": id},
            statusCode: {
                200: function (data) {
                    console.log(data);
                    // let user = JSON.parse(data);
                    viewUserInfo(data);
                },
                460: function () {
                    console.log("error")
                },
                500: function () {
                    alert("leh ya rb m 5k2tny4 m3za");
                }

            }
        });
    });

    function viewUserInfo(user) {
        $("#firstName").val(user.firstName);
        $("#lastName").val(user.lastName);
        $("#phone").val(user.phone);
        $("#country").val(user.address.country);
        $("#email").val(user.email);
        $("#birthDate").val(user.birthDate);
        $("#state").val(user.address.state);
        $("#street").val(user.address.street);
        $("#city").val(user.address.city);
        $("#zipCode").val(user.address.zipCode);
        //
        $("#title").text(user.firstName + " " + user.lastName);
        $("#role").text(user.role.replace("_ROEL", ""));
        $("#profileImage").attr('src', user.userImage);
        $("#orders").text(user.orders);
        $("#balance").text(user.balance);
    };
});