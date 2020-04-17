function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var id = input.id;
            console.log(id);
            $('#image' + id + '').attr('src', e.target.result);
            $('#image' + id + '').show();
        };

        reader.readAsDataURL(input.files[0]);
    }
}

$(document).ready(function () {
    $(document).on('click', '.addCategory', function () {
        var newCategoryName = $("#categoryName").val();
        $.ajax({
            url: "newCategory",
            type: "POST",
            dataType: "JSON",
            data: {"newCat": newCategoryName},
            statusCode: {
                200: function (data) {
                    $('#categories').append('<li>' +
                        '<input type="checkbox" class="small" name="categories" value="' + data.categoryId + '">' +
                        '&nbsp;' + data.categoryName + '</li>');
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
