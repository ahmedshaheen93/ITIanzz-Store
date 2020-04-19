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
                        alert("leh ya rb m 5k2tny4 m3za");
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
                        alert("leh ya rb m 5k2tny4 m3za");
                    }

                }
            });
        });

    });