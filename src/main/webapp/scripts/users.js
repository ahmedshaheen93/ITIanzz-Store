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
        console.log(user.role);
        if (user.role === "ADMIN_ROLE") {
            console.log("user is admin");
            $("#role").addClass('fa-star').removeClass('fa-user');
            $(".modal-header").addClass('bg-dark text-white');
            $(".modal-header button span ").addClass('text-white');
        } else {
            console.log("user is customer");
            $("#role").addClass('fa-user').removeClass('fa-star');
            $(".modal-header").removeClass('bg-dark text-white');
            $(".modal-header button span ").removeClass('text-white');
        }


        $("#profileImage").attr('src', user.userImage);
        $("#orders").text(user.orders.length);
        var orderHtml = "";
        user.orders.forEach(order => {
                console.log("add");
                var orderHeader = `<div class="card bg-light mb-3">
                                       <div class="card-header">
                                        <div class="d-flex justify-content-between">
                                            <div>
                                                <p class="card-text">#${order.orderId}</p>
                                            </div>
                                            <div>
                                                <p class="card-text"><small
                                                        class="text-muted">${order.orderTimestamp}</small>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                      <div class="card-body">
                                        <table class="table table-hover">
                                            <thead>
                                            <tr>
                                                <th scope="col">Product</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Price</th>
                                            </tr>
                                            </thead>
                                                            `;
                orderHtml += orderHeader;
                order.purchases.forEach(purchase => {
                    var orderBody = `
                        <tbody>
                         <tr>
                           <td>${purchase.product.productName}</td>
                             <td>${purchase.quantity} </td>
                            <td>${purchase.productBuyPrice} </td>
                             </tr>
                        </tbody>
                    
            `

                    orderHtml += orderBody;
                })
                orderHtml += `</table>
                                    </div>
                                </div>
                                <br>`
            }
        );
        $("#orderHistory").html(orderHtml);

        $("#balance").text(user.balance);
    }
    ;
})
;