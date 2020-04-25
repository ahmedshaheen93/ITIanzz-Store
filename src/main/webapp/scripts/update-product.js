function validateNumberOFiles(length, len) {

    if (length > len) {
        $('#filesValidator').modal('show');
        $('#updateBtn').attr('disabled', 'disabled');
    }else {
        $('#updateBtn').removeAttr('disabled');
    }
}

$(document).ready(function () {
    if (window.File && window.FileList && window.FileReader) {
        var filesInput = document.getElementById("files");
        filesInput.addEventListener("change", function (event) {
            var files = event.target.files; //FileList object
            var output = document.getElementById("result");
            output.innerHTML = '';
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                //Only pics
                if (!file.type.match('image'))
                    continue;
                var picReader = new FileReader();
                picReader.addEventListener("load", function (event) {
                    var picFile = event.target;
                    var div = document.createElement("div");
                    div.setAttribute("class", "col-4");
                    div.innerHTML = "<img class='thumbnail' src='" + picFile.result + "'" +
                        "title='" + picFile.name + "'/>";
                    output.insertBefore(div, null);
                });
                //Read the image
                picReader.readAsDataURL(file);
            }
        });
    } else {
        console.log("Your browser does not support File API");
    }
});

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
