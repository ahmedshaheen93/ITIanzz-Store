function validatePassword() {

    var validator = $("#userForm").validate({
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
}