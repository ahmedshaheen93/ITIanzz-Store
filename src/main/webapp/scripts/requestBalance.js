$(document).ready(
    function () {
        $(document).on('click', '.addBalance', function () {
            console.log("request for money")
            var amount = $("#requestBalance").val();
            console.log(amount)

            $.ajax({
                url: "scratchCard",
                type: "POST",
                dataType: "JSON",
                data: {"amount": amount},
                statusCode: {
                    200: function (data) {
                        console.log(data);
                        $("#Message").text("request for money has been sent , please pay " + amount + " to our account number ")
                        $('#myModel').modal('show');
                    },
                    460: function () {
                        console.log("error")
                    },
                    500: function () {
                        alert("error on server");
                    }

                }
            });
        });
        $(document).on('click', '.approveRequest', function () {
            console.log("approveRequest for money");
            var requestId = this.name;
            $(this).parents("tr").remove();

            $.ajax({
                url: "scratchCardRequest",
                type: "POST",
                dataType: "JSON",
                data: {"requestId": requestId, "operation": "approve"},
                statusCode: {
                    200: function (data) {
                        console.log(data);
                    },
                    460: function () {
                        console.log("error")
                    },
                    500: function () {
                        alert("error on server");
                    }

                }
            });
        });

        $(document).on('click', '.deleteRequest', function () {
            console.log("deleteRequest for money");
            var requestId = this.name;
            console.log(requestId);
            $(this).parents("tr").remove();

            $.ajax({
                url: "scratchCardRequest",
                type: "POST",
                dataType: "JSON",
                data: {"requestId": requestId, "operation": "delete"},
                statusCode: {
                    200: function (data) {
                        console.log(data);
                    },
                    460: function () {
                        console.log("error")
                    },
                    500: function () {
                        alert("error on server");
                    }

                }
            });
        });

    });